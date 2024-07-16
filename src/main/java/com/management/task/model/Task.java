package com.management.task.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tasks")
@Entity
@Getter
@Setter
public class Task {
    
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "title", length = 256, nullable = false)
    private String title;
    
    @Column(name = "deadline", length = 10, nullable = false)
    private LocalDateTime deadline;
    
    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted;
}