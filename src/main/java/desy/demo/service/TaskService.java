package desy.demo.service;

import desy.demo.model.service.TaskServiceModel;
import desy.demo.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void add(TaskServiceModel taskserviceModel);
    List<TaskViewModel> tasks();

    void changeTask(String id);
}
