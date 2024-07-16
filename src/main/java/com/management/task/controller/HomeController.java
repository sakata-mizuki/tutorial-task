package com.management.task.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.management.task.model.TaskForm;

@Controller
public class HomeController {

    record TaskItem(UUID id, String title, LocalDateTime deadline, Boolean isCompleted) {}

    private List<TaskItem> taskItems = new ArrayList<>();

    @RequestMapping(value="/hello")
    String hello(Model model) {
        model.addAttribute("time", LocalDateTime.now());
        return "hello";
    }

    @GetMapping("/home")
    String listItems(Model model) {
        model.addAttribute("taskList", taskItems);
        model.addAttribute("taskCreateForm", new TaskForm());
        return "home";
    }

    @PostMapping("/add")
    String addItem(@ModelAttribute("taskCreateForm") TaskForm form) {
        UUID id = UUID.randomUUID();
        TaskItem item = new TaskItem(id, form.getTitle(), form.getDeadline(), false);
        taskItems.add(item);
        return "redirect:/home";
    }
}