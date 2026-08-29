package com.hagydev.task_manager.task_manager.service;

import com.hagydev.task_manager.task_manager.dto.UserRequestDTO;
import com.hagydev.task_manager.task_manager.dto.UserResponseDTO;
import com.hagydev.task_manager.task_manager.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAll();
    UserResponseDTO findById(Long id);
    UserResponseDTO create(UserRequestDTO user);
    UserResponseDTO update(Long id, UserRequestDTO user);
    void delete(Long id);
}
