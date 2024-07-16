package com.management.task.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.task.model.Task;
import com.management.task.model.TaskForm;
import com.management.task.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void add(TaskForm form) {
        Task task = new Task();
        task.setTitle(form.getTitle());
        task.setDeadline(form.getDeadline());
        task.setIsCompleted(false);
        taskRepository.save(task);
    }

    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public void update(TaskForm form) {
        taskRepository.update(form.getId(), form.getTitle(), form.getDeadline(), form.getIsCompleted());
    }
}
