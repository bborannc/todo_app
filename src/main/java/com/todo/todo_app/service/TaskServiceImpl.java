package com.todo.todo_app.service;

import com.todo.todo_app.model.Task;
import com.todo.todo_app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    //Constructor injection

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findTaskById(Long id){
        return taskRepository.findById(id);
    }
    @Override
    public Task saveTask (Task task){
        return taskRepository.save(task);
    }
    @Override
    public Task updateTask(Task task){
        return taskRepository.save(task);
    }
    @Override
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

}
