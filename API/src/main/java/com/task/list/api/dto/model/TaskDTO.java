package com.task.list.api.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.task.list.api.model.task.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Optional;

@Getter
@Setter
@Accessors( chain = true )
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String description;
    private TaskStatus status;
}
