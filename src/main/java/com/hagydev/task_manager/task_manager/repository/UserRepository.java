package com.hagydev.task_manager.task_manager.repository;

import com.hagydev.task_manager.task_manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}