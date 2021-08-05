package com.task.list.api.controller;

import com.task.list.api.dto.model.TaskListDTO;
import com.task.list.api.services.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskListController {
    public static final String TASK_LIST_PATH = "/taskLists";
    private static final String TASK_LIST_USER_SPECIFIC_PATH = "/users/{userId}" + TASK_LIST_PATH;
    @Autowired
    private ITasksService tasksService;

    @GetMapping(TASK_LIST_USER_SPECIFIC_PATH)
    public List<TaskListDTO> getAll(@PathVariable Long userId) {
        return tasksService.getAllTaskLists(userId);
    }

    @PostMapping(TASK_LIST_USER_SPECIFIC_PATH)
    public TaskListDTO create(@RequestBody TaskListDTO taskListDTO, @PathVariable Long userId) {
        return tasksService.createTaskList(taskListDTO, userId);
    }

    @PutMapping(TASK_LIST_PATH)
    public TaskListDTO update(@RequestBody TaskListDTO taskListDTO) {
        return tasksService.updateTaskList(taskListDTO);
    }

}
