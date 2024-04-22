package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        // Implement logic to add a new task
        return taskRepository.save(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        // Implement logic to retrieve all tasks
        return taskRepository.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        // Implement logic to retrieve tasks by status
        return taskRepository.findAllByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        // Implement logic to update task status
        // You can use taskRepository.findById(id) to retrieve the existing task
        // and then update its status
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        // Implement logic to delete a task by ID
        taskRepository.deleteById(id);
    }
}