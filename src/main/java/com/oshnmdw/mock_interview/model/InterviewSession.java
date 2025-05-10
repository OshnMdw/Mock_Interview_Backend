package com.oshnmdw.mock_interview.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class InterviewSession {
    @Id @GeneratedValue
    private Long id;
    private LocalDateTime createdAt;
    private String status; // e.g., "PENDING", "COMPLETED"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "session")
    private List<InterviewQuestion> questions;
}
