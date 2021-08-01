package com.task.list.api.dto.mapper;

import com.task.list.api.dto.model.TaskDTO;
import com.task.list.api.model.task.Task;

import java.util.Optional;

public class TaskToDTO {
    public static TaskDTO toTaskDTO(Task task) {
        return new TaskDTO()
                .setId(task.getId())
                .setDescription(task.getDescription())
                .setStatus(task.getStatus());
    }
}
