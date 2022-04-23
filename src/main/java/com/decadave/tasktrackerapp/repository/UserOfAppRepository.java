package com.decadave.tasktrackerapp.repository;

import com.decadave.tasktrackerapp.models.UserOfApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserOfAppRepository extends JpaRepository<UserOfApp, Long> {

    Optional<UserOfApp> findByEmail(String email);
}
