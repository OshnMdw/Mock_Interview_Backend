package com.oshnmdw.mock_interview.repo;

import com.oshnmdw.mock_interview.model.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Long> {
}
