package com.task.list.api.controller;

import com.task.list.api.dto.model.TaskDTO;
import com.task.list.api.exception.EntityNotFoundException;
import com.task.list.api.services.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.task.list.api.controller.TaskListController.TASK_LIST_PATH;

@RestController
public class TaskController {
    private static final String TASK_PATH = "/tasks";
    private static final String TASK_TASK_LIST_SPECIFIC_PATH = TASK_LIST_PATH + "/{taskListId}" + TASK_PATH;

    @Autowired
    private ITasksService tasksService;

    @GetMapping(TASK_TASK_LIST_SPECIFIC_PATH)
    public List<TaskDTO> getAll(@PathVariable Long taskListId) {
        return tasksService.getAllTasks(taskListId);
    }


    @PostMapping(TASK_TASK_LIST_SPECIFIC_PATH)
    public TaskDTO create(@RequestBody TaskDTO taskDTO, @PathVariable Long taskListId) {
        return tasksService.createTask(taskDTO, taskListId);
    }

    @PutMapping(TASK_PATH)
    public TaskDTO update(@RequestBody TaskDTO taskDTO) {
        return tasksService.updateTask(taskDTO);
    }
}
