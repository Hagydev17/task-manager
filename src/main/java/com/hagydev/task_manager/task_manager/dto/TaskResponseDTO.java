package com.hagydev.task_manager.task_manager.dto;

import com.hagydev.task_manager.task_manager.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        TaskStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
