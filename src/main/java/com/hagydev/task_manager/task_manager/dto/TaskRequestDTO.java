package com.hagydev.task_manager.task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequestDTO(
        @NotBlank(message = "La tarea debe tener un título")
        @Size(min = 3, max = 100)
        String title,
        @Size(min = 3, max = 500)
        @NotBlank(message = "La tarea debe tener una descripción")
        String description
) {
}
