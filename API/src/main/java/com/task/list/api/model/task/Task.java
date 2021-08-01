package com.task.list.api.model.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Task {

    public Task(String description, TaskStatus status, TaskList taskList) {
        this.description = description;
        this.status = status;
        this.taskList = taskList;
    }

    private
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long id;

    private
    @NotNull
    String description;

    private
    @NotNull
    @Enumerated(EnumType.STRING)
    TaskStatus status;

    @ManyToOne
    @JoinColumn( name = "TASK_LIST_ID")
    @NotNull
    private TaskList taskList;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
