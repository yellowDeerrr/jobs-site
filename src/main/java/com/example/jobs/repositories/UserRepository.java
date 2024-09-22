package com.example.jobs.repositories;

import com.example.jobs.tables.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
    UserEntity findByUUID(String uuid);
}
