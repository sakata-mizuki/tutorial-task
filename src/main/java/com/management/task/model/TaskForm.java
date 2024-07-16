package com.management.task.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class TaskForm {
	
	private UUID id;
	
	private String title;
	
	private LocalDateTime deadline;
	
	private Boolean isCompleted;

}
