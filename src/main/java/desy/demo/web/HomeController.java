package desy.demo.web;

import desy.demo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/home")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        } else {
            if(!model.containsAttribute("tasks")){
                model.addAttribute("tasks", this.taskService.tasks());
            }
            return "home";
        }
    }
    @GetMapping("/home/{id}")
    public String buyById(@PathVariable String id){
        this.taskService.changeTask(id);
        return "redirect:/home";
    }
}
