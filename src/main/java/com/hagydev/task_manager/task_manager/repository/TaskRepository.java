package com.hagydev.task_manager.task_manager.repository;

import com.hagydev.task_manager.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
