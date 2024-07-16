package com.management.task.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {
	@Modifying
    @Query("UPDATE Task t set t.title = :title, t.deadline = :deadline, t.isCompleted = :isCompleted where t.id = :id")
    void update(@Param("id") UUID id, @Param("title") String task, @Param("deadline") LocalDateTime deadline, @Param("isCompleted") Boolean isCompleted);
}
