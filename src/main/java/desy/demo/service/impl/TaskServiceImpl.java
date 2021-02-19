package desy.demo.service.impl;

import desy.demo.model.entity.Task;
import desy.demo.model.entity.User;
import desy.demo.model.service.TaskServiceModel;
import desy.demo.model.service.UserServiceModel;
import desy.demo.model.view.TaskViewModel;
import desy.demo.repository.TaskRepository;
import desy.demo.service.ClassificationService;
import desy.demo.service.TaskService;
import desy.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private  final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final ClassificationService classificationService;
    private final UserService userService;
    private final HttpSession httpSession;


    public TaskServiceImpl(ModelMapper modelMapper, TaskRepository taskRepository, ClassificationService classificationService, UserService userService, HttpSession httpSession) {
        this.modelMapper = modelMapper;
        this.taskRepository = taskRepository;
        this.classificationService = classificationService;
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @Override
    public void add(TaskServiceModel taskserviceModel) {
        taskserviceModel.setProgress("OPEN");
        taskserviceModel.setUserName(userService.getUserName((UserServiceModel) httpSession.getAttribute("user")));
        Task task=this.modelMapper.map(taskserviceModel,Task.class);
        task.setClassification(this.classificationService.findByClassificationaname(taskserviceModel.getClassification()));
        task.setUser(this.userService.findUserByName(taskserviceModel.getUserName()));
        this.taskRepository.saveAndFlush(task);


    }

    @Override
    public List<TaskViewModel> tasks() {
        return this.taskRepository.findAll()
                .stream()
                .map(t -> {
                    TaskViewModel task = this.modelMapper.map(t, TaskViewModel.class);
                    task.setAssigned_to(t.getUser().getUsername());
                    task.setClassification(t.getClassification().getClassificationName());
                    task.setDue_date(t.getDueDate());
                    return task;
                }).collect(Collectors.toList());
    }

    @Override
    public void changeTask(String id) {
        Task task = this.taskRepository.findById(id).get();

        if (task.getProgress().equals("COMPLETED")) {
            this.taskRepository.delete(task);
        } else {
            changeProgress(task);
            taskRepository.save(task);

        }
    }

    private Task changeProgress(Task task) {
        switch (task.getProgress()) {
            case "OPEN":
                task.setProgress("IN_PROGRESS");
                break;
            case "IN_PROGRESS":
                task.setProgress("COMPLETED");
                break;

        }
        return task;
    }
}
