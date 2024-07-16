package com.management.task.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.management.task.model.Task;
import com.management.task.model.TaskForm;
import com.management.task.service.TaskService;

@Controller
public class HomeController {

    private final TaskService taskService;

    @Autowired
    public HomeController(TaskService service) {
        this.taskService = service;
    }

    @GetMapping("/home")
    String listItems(Model model) {
        List<Task> taskList = taskService.findAll();
        model.addAttribute("taskList", taskList);
        model.addAttribute("taskCreateForm", new TaskForm());
        return "home";
    }

    @PostMapping("/add")
    String addItem(
    		@ModelAttribute("taskCreateForm") TaskForm form
    ) {
        taskService.add(form);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    String deleteItem(@RequestParam("id") UUID id) {
        taskService.delete(id);
        return "redirect:/home";
    }

    @PostMapping("/update")
    String updateItem(
            @ModelAttribute("taskUpdateForm") TaskForm form
    ) {
        taskService.update(form);
        return "redirect:/home";
    }
}