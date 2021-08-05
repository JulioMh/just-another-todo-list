package com.task.list.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entity, Long id) {
        super("Could not find " + entity + " with id: " + id);
    }
    public EntityNotFoundException(String username) {
        super("Could not find user with username: " + username);
    }
}
