package com.task.list.api.persistence.repositories.user;

import com.task.list.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
