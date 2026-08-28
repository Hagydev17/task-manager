package com.hagydev.task_manager.task_manager.service;

import com.hagydev.task_manager.task_manager.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);
}
