package com.task.list.api.services;

import com.task.list.api.dto.model.TaskDTO;
import com.task.list.api.dto.model.TaskListDTO;

import java.util.List;

public interface ITasksService {

    // TaskLists
    List<TaskListDTO> getAllTaskLists(Long userId);
    TaskListDTO createTaskList(TaskListDTO taskListDTO, Long userId);
    TaskListDTO updateTaskList(TaskListDTO taskListDTO);
    void removeTaskList(Long taskListId);

    // Tasks
    List<TaskDTO> getAllTasks(Long taskListId);
    TaskDTO createTask(TaskDTO taskDTO, Long taskListId);
    TaskDTO updateTask(TaskDTO taskDTO);
    void removeTask(Long taskId);
}
