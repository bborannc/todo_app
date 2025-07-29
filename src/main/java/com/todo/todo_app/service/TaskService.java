package com.todo.todo_app.service;

import com.todo.todo_app.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAllTasks();
    Optional<Task> findTaskById(Long id);
    Task saveTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Long id);
}

