package com.decadave.tasktrackerapp.models;

import com.decadave.tasktrackerapp.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="task_by_user")
public class Task extends BaseClass {
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status statusOfTask;
    private LocalDateTime completedAt;
}
