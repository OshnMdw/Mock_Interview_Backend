package com.oshnmdw.mock_interview.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "app_user")
public class User {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<InterviewSession> interviewSessions;
}
