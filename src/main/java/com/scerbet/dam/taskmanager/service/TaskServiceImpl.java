package com.scerbet.dam.taskmanager.service;

import com.scerbet.dam.taskmanager.exception.TaskNotFoundException;
import com.scerbet.dam.taskmanager.model.Priority;
import com.scerbet.dam.taskmanager.model.Task;
import com.scerbet.dam.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedAt(now);
        task.setUpdatedAt(now);
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public Task updateTask(String id, Task updatedTask) {
        Task existingTask = getTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setTags(updatedTask.getTags());
        existingTask.setCategory(updatedTask.getCategory());
        existingTask.setDueDate(updatedTask.getDueDate());

        // Actualizar solo la fecha de modificación
        existingTask.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(String id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    @Override
    public List<Task> findByCompleted(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    @Override
    public List<Task> findByCategory(String category) {
        return taskRepository.findByCategory(category);
    }

    @Override
    public List<Task> findByTagsContaining(String tag) {
        return taskRepository.findByTagsContaining(tag);
    }

    @Override
    public List<Task> findByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }

    @Override
    public Task setCompleted(String id, boolean completed) {
        Task task = getTaskById(id);
        task.setCompleted(completed);
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findByTitleContaining(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }
}