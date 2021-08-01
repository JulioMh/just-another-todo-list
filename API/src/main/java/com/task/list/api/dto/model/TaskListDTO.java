package com.task.list.api.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors( chain = true )
public class TaskListDTO {
    private Long id;
    private String name;
}
