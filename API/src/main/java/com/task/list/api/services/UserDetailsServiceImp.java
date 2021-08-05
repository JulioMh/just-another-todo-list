package com.task.list.api.services;

import com.task.list.api.exception.EntityNotFoundException;
import com.task.list.api.model.user.UserDetailsImp;
import com.task.list.api.persistence.repositories.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new UserDetailsImp(userRepository.findByUsername(s).orElseThrow(() -> new EntityNotFoundException(s)));
    }
}
