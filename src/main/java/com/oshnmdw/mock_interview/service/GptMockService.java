package com.oshnmdw.mock_interview.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GptMockService {


    public List<String> generateInterviewQuestions(String cvText) {
        return List.of(
                "Can you explain your final year project and how you used GNNs to analyze fMRI data?",
                "How would you optimize performance in a React + Node.js full stack application?",
                "What challenges did you face during the development of DriveSmart, and how did you overcome them?",
                "How would you explain the difference between supervised and unsupervised learning?",
                "Can you walk me through how you implemented CI/CD or testing in any of your projects?"
        );
    }


}
