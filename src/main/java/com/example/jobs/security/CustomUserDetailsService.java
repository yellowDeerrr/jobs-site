package com.example.jobs.security;

import com.example.jobs.repositories.UserRepository;
import com.example.jobs.tables.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public CustomUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByLogin(login);

        if (userEntity == null)
            throw new UsernameNotFoundException("User not found");

        return new CustomUserDetails(userEntity);
    }
}