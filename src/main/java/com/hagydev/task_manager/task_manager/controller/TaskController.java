package com.hagydev.task_manager.task_manager.controller;

import com.hagydev.task_manager.task_manager.entity.Task;
import com.hagydev.task_manager.task_manager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> task = taskService.findAll();
        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> create (@RequestBody @Valid Task request) {
        Task task = taskService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody @Valid Task request) {
        Task task = taskService.update(id, request);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
