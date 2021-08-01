package com.task.list.api.persistence;

import com.task.list.api.model.task.Task;
import com.task.list.api.model.task.TaskList;
import com.task.list.api.model.task.TaskStatus;
import com.task.list.api.model.user.User;
import com.task.list.api.persistence.repositories.task.ITaskListRepository;
import com.task.list.api.persistence.repositories.task.ITaskRepository;
import com.task.list.api.persistence.repositories.user.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.codec.Hex;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class Context {
    private static final Logger log = LoggerFactory.getLogger(Context.class);

    @Bean
    CommandLineRunner initDatabase(
            IUserRepository userRepository,
            ITaskListRepository taskListRepository,
            ITaskRepository taskRepository
    ) {
        return args -> {
            User user = new User("kilojulio", Hex.encode("patata".getBytes(StandardCharsets.UTF_8)));
            log.info("Create user " + userRepository.save(user));
            TaskList taskList = new TaskList("Things to buy", user);
            log.info("Create taskList " + taskListRepository.save(taskList));
            user.setTaskLists(List.of(taskList));
            log.info("Link taskList to user " + userRepository.save(user));
            Task task = new Task("Buy apples", TaskStatus.PENDING, taskList);
            List<Task> list = taskList.getTaskList();
            list.add(task);
            taskList.setTaskList(list);
            log.info("Create task " + taskRepository.save(task));

            log.info("Done");
        };
    }
}
