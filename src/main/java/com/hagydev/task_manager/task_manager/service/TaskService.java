package com.hagydev.task_manager.task_manager.service;

import com.hagydev.task_manager.task_manager.dto.TaskRequestDTO;
import com.hagydev.task_manager.task_manager.dto.TaskResponseDTO;
import com.hagydev.task_manager.task_manager.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponseDTO> findAll();

    TaskResponseDTO findById(Long id);

    TaskResponseDTO create(TaskRequestDTO taskRequestDTO);

    TaskResponseDTO update(Long id, TaskRequestDTO taskRequestDTO);

    void delete(Long id);
}