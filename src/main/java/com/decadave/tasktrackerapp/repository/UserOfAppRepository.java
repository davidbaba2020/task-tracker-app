package com.decadave.tasktrackerapp.repository;

import com.decadave.tasktrackerapp.models.UserOfApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOfAppRepository extends JpaRepository<UserOfApp, Long> {

}
