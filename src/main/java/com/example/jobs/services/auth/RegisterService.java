package com.example.jobs.services.auth;

import com.example.jobs.payload.requests.auth.RegisterRequest;
import com.example.jobs.repositories.RoleRepository;
import com.example.jobs.repositories.UserRepository;
import com.example.jobs.tables.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(RegisterRequest registerRequest) {
        String login = registerRequest.getLogin();
        String firstName = registerRequest.getFirstName();
        String secondName = registerRequest.getSecondName();

        if (userRepository.findByLogin(login) != null) {
            return false;
        } else {
            UserEntity userEntity = new UserEntity();

            userEntity.setLogin(login);
            userEntity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            userEntity.setFirstName(firstName);
            userEntity.setSecondName(secondName);
            userEntity.setUUID(UUID.randomUUID().toString());
            userEntity.setRoles(Collections.singletonList(roleRepository.findByName("ROLE_USER").get()));

            userRepository.save(userEntity);
            return true;
        }
    }
}