package com.decadave.tasktrackerapp.repository;

import com.decadave.tasktrackerapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
