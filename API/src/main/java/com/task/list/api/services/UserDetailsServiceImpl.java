package com.task.list.api.services;

import com.task.list.api.exception.NotFoundException;
import com.task.list.api.model.user.User;
import com.task.list.api.persistence.repositories.user.IUserRepository;
import com.task.list.api.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new UserDetailsImpl(
                userRepository.findByUsername(s)
                        .orElseThrow(() -> new UsernameNotFoundException(s)));
    }
}
