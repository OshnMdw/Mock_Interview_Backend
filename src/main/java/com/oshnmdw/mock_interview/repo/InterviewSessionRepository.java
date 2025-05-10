package com.oshnmdw.mock_interview.repo;

import com.oshnmdw.mock_interview.model.InterviewSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewSessionRepository extends JpaRepository<InterviewSession, Long> {
    List<InterviewSession> findByUserId(Long userId);
}
