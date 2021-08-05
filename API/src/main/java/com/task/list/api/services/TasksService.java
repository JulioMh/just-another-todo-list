package com.task.list.api.services;

import com.task.list.api.dto.mapper.TaskListToDTO;
import com.task.list.api.dto.mapper.TaskToDTO;
import com.task.list.api.dto.model.TaskDTO;
import com.task.list.api.dto.model.TaskListDTO;
import com.task.list.api.exception.EntityNotFoundException;
import com.task.list.api.model.task.Task;
import com.task.list.api.model.task.TaskList;
import com.task.list.api.model.task.TaskStatus;
import com.task.list.api.model.user.User;
import com.task.list.api.persistence.repositories.task.ITaskListRepository;
import com.task.list.api.persistence.repositories.task.ITaskRepository;
import com.task.list.api.persistence.repositories.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.task.list.api.dto.mapper.TaskListToDTO.toTaskListDTO;
import static com.task.list.api.dto.mapper.TaskToDTO.toTaskDTO;

@Service
public class TasksService implements ITasksService {
    @Autowired
    private ITaskListRepository taskListRepository;
    @Autowired
    private ITaskRepository taskRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<TaskListDTO> getAllTaskLists(Long userId) {
        return taskListRepository
                .findAllById(
                        getUser(userId).getTaskLists()
                                .stream()
                                .map(TaskList::getId)
                                .collect(Collectors.toList())
                )
                .stream()
                .map(TaskListToDTO::toTaskListDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskListDTO createTaskList(TaskListDTO taskListDTO, Long userId) {
        var user = getUser(userId);

        var taskList = new TaskList()
                .setName(taskListDTO.getName())
                .setUser(user)
                .setTaskList(new ArrayList<>());

        user.setTaskLists(
                Stream.concat(
                        user.getTaskLists().stream(),
                        Stream.of(taskList)
                ).collect(Collectors.toList()));

        taskListRepository.save(taskList);
        userRepository.save(user);

        return toTaskListDTO(taskList);
    }

    @Override
    public TaskListDTO updateTaskList(TaskListDTO taskListDTO) {
        return toTaskListDTO(taskListRepository.save(
                getTaskList(taskListDTO.getId())
                        .setName(taskListDTO.getName())
        ));
    }

    @Override
    public void removeTaskList(Long taskListId) {
        taskListRepository.delete(getTaskList(taskListId));
    }

    @Override
    public List<TaskDTO> getAllTasks(Long taskListId) {
        return taskRepository.findAllById(
                    getTaskList(taskListId).getTaskList()
                            .stream()
                            .map(Task::getId)
                            .collect(Collectors.toList())
                )
                .stream()
                .map(TaskToDTO::toTaskDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO, Long taskListId) {
        var taskList = getTaskList(taskListId);

        var task = new Task()
                .setDescription(taskDTO.getDescription())
                .setStatus(TaskStatus.PENDING)
                .setTaskList(taskList);

        taskList.setTaskList(
                Stream.concat(
                        taskList.getTaskList().stream(),
                        Stream.of(task)
                ).collect(Collectors.toList()));

        taskRepository.save(task);
        taskListRepository.save(taskList);

        return toTaskDTO(task);
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO) {
        var task = getTask(taskDTO.getId());
        return toTaskDTO(taskRepository.save(
                task
                        .setStatus(
                                taskDTO.getStatus() == null ? task.getStatus() : taskDTO.getStatus())
                        .setDescription(
                                taskDTO.getDescription() == null ? task.getDescription() : taskDTO.getDescription())
        ));
    }

    @Override
    public void removeTask(Long taskId) {
        taskRepository.delete(getTask(taskId));
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("user", userId));
    }

    private TaskList getTaskList(Long taskListId) {
        return taskListRepository.findById(taskListId)
                .orElseThrow(() -> new EntityNotFoundException("taskList", taskListId));
    }

    private Task getTask(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("task", taskId));
    }
}
