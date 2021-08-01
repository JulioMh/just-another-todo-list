package com.task.list.api.persistence.repositories.task;

import com.task.list.api.model.task.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskListRepository extends JpaRepository<TaskList, Long> {
}
