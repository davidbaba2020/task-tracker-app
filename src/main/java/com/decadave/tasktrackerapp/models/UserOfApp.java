package com.decadave.tasktrackerapp.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user_table")
public class UserOfApp extends BaseClass{
    @Column(nullable = false, length = 20)
    private String firstName;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false,length = 64)
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> usersCreatedTaskList = new ArrayList<Task>();
}
