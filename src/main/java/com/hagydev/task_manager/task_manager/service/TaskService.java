package com.hagydev.task_manager.task_manager.service;

import com.hagydev.task_manager.task_manager.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task findById(Long id);

    Task create(Task task);

    Task update(Long id, Task task);

    void delete(Long id);
}