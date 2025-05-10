package com.oshnmdw.mock_interview.model;

import jakarta.persistence.*;

@Entity
public class InterviewQuestion {
    @Id @GeneratedValue
    private Long id;
    private String QuestionText;
    private String AnswerTranscript;
    private int score;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private InterviewSession session;

}
