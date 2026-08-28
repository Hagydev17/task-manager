package com.hagydev.task_manager.task_manager.service.impl;

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
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return findUserById(id);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User updatedUser) {
        User existingUser = findUserById(id);

        if(updatedUser.getName() != null) existingUser.setName(updatedUser.getName());
        if(updatedUser.getEmail() != null) existingUser.setEmail(updatedUser.getEmail());
        if(updatedUser.getPassword() != null) existingUser.setPassword(updatedUser.getPassword());

        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }
}
