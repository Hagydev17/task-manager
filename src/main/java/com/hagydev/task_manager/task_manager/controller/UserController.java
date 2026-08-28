package com.hagydev.task_manager.task_manager.controller;

import com.hagydev.task_manager.task_manager.entity.User;
import com.hagydev.task_manager.task_manager.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> user = userService.findAll();
        return ResponseEntity.ok(user);
    }
}
