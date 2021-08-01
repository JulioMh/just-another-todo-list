package com.task.list.api.controller;

import com.task.list.api.dto.model.TaskDTO;
import com.task.list.api.services.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.task.list.api.controller.TaskListController.TASK_LIST_PATH;

@RestController
public class TaskController {
    private final static String TASK_PATH = "/tasks";
    private final static String TASK_TASK_LIST_SPECIFIC_PATH = TASK_LIST_PATH + "/{taskListId}" + TASK_PATH;
    @Autowired
    private ITasksService tasksService;

    @GetMapping(TASK_TASK_LIST_SPECIFIC_PATH)
    public ResponseEntity getAll(@PathVariable Long taskListId) {
        try {
            return new ResponseEntity(tasksService.getAllTasks(taskListId), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(TASK_TASK_LIST_SPECIFIC_PATH)
    public ResponseEntity create(@RequestBody TaskDTO taskDTO, @PathVariable Long taskListId) {
        try {
            return new ResponseEntity(tasksService.createTask(taskDTO, taskListId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(TASK_PATH)
    public ResponseEntity update(@RequestBody TaskDTO taskDTO) {
        try {
            return new ResponseEntity(tasksService.updateTask(taskDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
