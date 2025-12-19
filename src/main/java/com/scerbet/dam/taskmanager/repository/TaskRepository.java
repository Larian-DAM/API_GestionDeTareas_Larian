package com.scerbet.dam.taskmanager.repository;

import com.scerbet.dam.taskmanager.model.Priority;
import com.scerbet.dam.taskmanager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    // Métodos de consulta personalizados
    List<Task> findByCompleted(boolean completed);
    List<Task> findByCategory(String category);
    List<Task> findByTagsContaining(String tag);
    List<Task> findByPriority(Priority priority);
    List<Task> findByTitleContainingIgnoreCase(String title);
    List<Task> findByDueDateBefore(LocalDateTime date);
}