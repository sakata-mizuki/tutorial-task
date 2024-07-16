package com.management.task.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
	
	record TaskItem(UUID id, String title, LocalDateTime deadline, Boolean isCompleted) {}

	private List<TaskItem> taskItems = new ArrayList<>();
	
	@RequestMapping(value="/resthello")
	String hello() {
		return """
				Hello.
				It works!
				現在時刻は$sです。""".formatted(LocalDateTime.now());
	}
	
	@GetMapping("/restadd")
	String addItem(@RequestParam("title") String title, @RequestParam("deadline") LocalDateTime deadline) {
		UUID id = UUID.randomUUID();
		TaskItem item = new TaskItem(id, title, deadline, false);
		taskItems.add(item);
		return "タスクを追加しました";
	}
	
	@GetMapping("/restlist")
	String listItems() {
		String result = taskItems.stream().map(TaskItem::toString).collect(Collectors.joining(", "));
		return result;
	}
}