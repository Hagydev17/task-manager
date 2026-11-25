package com.hagydev.task_manager.task_manager.service;

import com.hagydev.task_manager.task_manager.dto.TaskRequestDTO;
import com.hagydev.task_manager.task_manager.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {
    List<TaskResponseDTO> findAll(Long userId);

    TaskResponseDTO findById(Long id);

    TaskResponseDTO create(Long userId, TaskRequestDTO taskRequestDTO);

    TaskResponseDTO update(Long id, TaskRequestDTO taskRequestDTO);

    void delete(Long id);
}