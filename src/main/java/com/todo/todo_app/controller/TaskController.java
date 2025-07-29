package com.todo.todo_app.controller;

import com.todo.todo_app.model.Task;
import com.todo.todo_app.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    // Tüm görevleri getir
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAllTasks();
    }
    //ID'ye göre görev getir
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return taskService.findTaskById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //Yeni görev oluştur
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task created = taskService.saveTask(task);
        return ResponseEntity.ok(created);
    }

    //Görev güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task updatedTask){
        return taskService.findTaskById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            Task saved = taskService.updateTask(task);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());


        }

        //Görev sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
