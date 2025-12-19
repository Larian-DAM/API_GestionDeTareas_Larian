package com.scerbet.dam.taskmanager.model;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {

    @Id
    String id; // Lo asigna MongoDB

    @NotNull
    @Size(min = 1, max = 100)
    String title;

    @Size(max = 500)
    String description;

    @NotNull
    boolean completed;

    @NotNull
    Priority priority;

    @NotNull
    List<String> tags;

    @NotNull
    String category;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    LocalDateTime dueDate;
}