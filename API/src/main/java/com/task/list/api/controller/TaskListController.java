package com.task.list.api.controller;

import com.task.list.api.dto.model.TaskListDTO;
import com.task.list.api.services.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskListController {
    public final static String TASK_LIST_PATH = "/taskLists";
    private final static String TASK_LIST_USER_SPECIFIC_PATH = "/users/{userId}" + TASK_LIST_PATH;
    @Autowired
    private ITasksService tasksService;

    @GetMapping(TASK_LIST_USER_SPECIFIC_PATH)
    public ResponseEntity getAll(@PathVariable Long userId) {
        try {
            return new ResponseEntity(tasksService.getAllTaskLists(userId), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(TASK_LIST_USER_SPECIFIC_PATH)
    public ResponseEntity create(@RequestBody TaskListDTO taskListDTO, @PathVariable Long userId) {
        try {
            return new ResponseEntity(tasksService.createTaskList(taskListDTO, userId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(TASK_LIST_PATH)
    public ResponseEntity update(@RequestBody TaskListDTO taskListDTO) {
        try {
            return new ResponseEntity(tasksService.updateTaskList(taskListDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
