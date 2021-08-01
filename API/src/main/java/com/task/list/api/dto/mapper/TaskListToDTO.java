package com.task.list.api.dto.mapper;

import com.task.list.api.dto.model.TaskListDTO;
import com.task.list.api.model.task.TaskList;

public class TaskListToDTO {
    public static TaskListDTO toTaskListDTO (TaskList taskList) {
        return new TaskListDTO()
                .setId(taskList.getId())
                .setName(taskList.getName());
    }
}
