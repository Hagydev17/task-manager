package com.hagydev.task_manager.task_manager.service.impl;

import com.hagydev.task_manager.task_manager.dto.UserRequestDTO;
import com.hagydev.task_manager.task_manager.dto.UserResponseDTO;
import com.hagydev.task_manager.task_manager.entity.User;
import com.hagydev.task_manager.task_manager.exception.UserNotFoundException;
import com.hagydev.task_manager.task_manager.repository.UserRepository;
import com.hagydev.task_manager.task_manager.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getName(), user.getEmail()))
                .toList();
    }

    @Override
    public UserResponseDTO findById(Long id) {
        User user = findUserById(id);
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());

        User userSaved = userRepository.save(user);

        return new UserResponseDTO(userSaved.getId(), userSaved.getName(), user.getEmail());
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO updatedUser) {
        User existingUser = findUserById(id);

        if (updatedUser.name() != null)
            existingUser.setName(updatedUser.name());
        if (updatedUser.email() != null)
            existingUser.setEmail(updatedUser.email());

        userRepository.save(existingUser);
        return new UserResponseDTO(existingUser.getId(), existingUser.getName(), existingUser.getEmail());
    }

    @Override
    public void delete(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }
}
