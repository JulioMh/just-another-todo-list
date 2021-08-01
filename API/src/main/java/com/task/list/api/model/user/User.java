package com.task.list.api.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.task.list.api.model.task.TaskList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class User {

    public User (String username, char[] passowrd) {
        this.username = username;
        this.password = passowrd;
        taskLists = new ArrayList<>();
    }

    private
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    Long id;

    private
    @NotNull
    String username;

    private
    @NotNull
    char[] password;

    // With mappedBy we are telling to JPA that the relationship has already been defined by another entity (no need to create another FK)
    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL )
    private
    List<TaskList> taskLists;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", taskLists=" + taskLists +
                '}';
    }
}
