package com.scerbet.dam.taskmanager.service;

import com.scerbet.dam.taskmanager.model.Priority;
import com.scerbet.dam.taskmanager.model.Task;

import java.util.List;

public interface TaskService {
    // Crear una tarea
    public Task createTask(Task task);

    // Obtener todas las tareas
    public List<Task> getAllTasks();

    // Obtener una tarea por ID
    public Task getTaskById(String id);

    // Actualizar una tarea
    public Task updateTask(String id, Task task);

    // Borrar una tarea
    public void deleteTask(String id);

    // Buscar tareas por diferentes criterios
    public List<Task> findByCompleted(boolean completed);
    public List<Task> findByCategory(String category);
    public List<Task> findByTagsContaining(String tag);
    public List<Task> findByPriority(Priority priority);
    public List<Task> findByTitleContaining(String title);

    // Marcar tarea como completada o no completada
    public Task setCompleted(String id, boolean completed);
}
