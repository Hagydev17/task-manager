package com.hagydev.task_manager.task_manager.repository;

import com.hagydev.task_manager.task_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}