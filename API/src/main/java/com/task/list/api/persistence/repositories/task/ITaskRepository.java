package com.task.list.api.persistence.repositories.task;

import com.task.list.api.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}
