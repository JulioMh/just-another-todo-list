package com.task.list.api.model.task;

import com.task.list.api.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "TASK_LIST")
@Entity
public class TaskList {

    public TaskList(String name, User user) {
        this.name = name;
        this.user = user;
        this.taskList = new ArrayList<>();
    }

    private
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long id;

    private
    @NotNull
    String name;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID") // Creates a FK named USER_ID in this table
    private User user;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    private List<Task> taskList;

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
