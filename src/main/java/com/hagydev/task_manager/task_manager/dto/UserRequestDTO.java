package com.hagydev.task_manager.task_manager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record UserRequestDTO(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El email no es válido")
        String email,
        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 8, max = 16, message = "La contraseña debe tener entre 8 y 16 caracteres")
        String password
) {
}
