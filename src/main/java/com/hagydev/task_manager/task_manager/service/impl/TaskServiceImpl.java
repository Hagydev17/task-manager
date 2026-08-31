package com.hagydev.task_manager.task_manager.service.impl;

import com.hagydev.task_manager.task_manager.entity.Task;
import com.hagydev.task_manager.task_manager.exception.TaskNotFoundException;
import com.hagydev.task_manager.task_manager.repository.TaskRepository;
import com.hagydev.task_manager.task_manager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return findTaskById(id);
    }

    @Override
    public Task create(Task task) {
        Task t = new Task();

        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        t.setStatus(task.getStatus());
        t.setCreatedAt(task.getCreatedAt());
        t.setUpdatedAt(task.getUpdatedAt());

        return taskRepository.save(t);
    }

    @Override
    public Task update(Long id, Task updatedTask) {
        Task existingTask = findTaskById(id);

        if (updatedTask.getTitle() != null) existingTask.setTitle(updatedTask.getTitle());
        if (updatedTask.getDescription() != null) existingTask.setTitle(updatedTask.getDescription());
        return taskRepository.save(existingTask);
    }

    @Override
    public void delete(Long id) {
        Task t = findTaskById(id);
        taskRepository.delete(t);
    }
}
