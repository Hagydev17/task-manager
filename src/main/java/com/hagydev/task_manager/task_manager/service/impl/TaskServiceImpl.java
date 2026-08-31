package com.hagydev.task_manager.task_manager.service.impl;

import com.hagydev.task_manager.task_manager.dto.TaskRequestDTO;
import com.hagydev.task_manager.task_manager.dto.TaskResponseDTO;
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
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    @Override
    public List<TaskResponseDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(task -> new TaskResponseDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getCreatedAt(),
                        task.getUpdatedAt()))
                .toList();
    }

    @Override
    public TaskResponseDTO findById(Long id) {
        Task task = findTaskById(id);
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getUpdatedAt());
    }

    @Override
    public TaskResponseDTO create(TaskRequestDTO taskRequestDTO) {
        Task task = new Task();

        task.setTitle(taskRequestDTO.title());
        task.setDescription(taskRequestDTO.description());

        Task taskSaved = taskRepository.save(task);

        return new TaskResponseDTO(
                taskSaved.getId(),
                taskSaved.getTitle(),
                taskSaved.getDescription(),
                taskSaved.getStatus(),
                taskSaved.getCreatedAt(),
                taskSaved.getUpdatedAt());
    }

    @Override
    public TaskResponseDTO update(Long id, TaskRequestDTO updatedTask) {
        Task existingTask = findTaskById(id);

        if (updatedTask.title() != null)
            existingTask.setTitle(updatedTask.title());
        if (updatedTask.description() != null)
            existingTask.setTitle(updatedTask.description());

        Task taskSaved = taskRepository.save(existingTask);
        return new TaskResponseDTO(
                taskSaved.getId(),
                taskSaved.getTitle(),
                taskSaved.getDescription(),
                taskSaved.getStatus(),
                taskSaved.getCreatedAt(),
                taskSaved.getUpdatedAt());
    }

    @Override
    public void delete(Long id) {
        Task task = findTaskById(id);
        taskRepository.delete(task);
    }
}
