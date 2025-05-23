package com.oshnmdw.mock_interview.service;

import com.oshnmdw.mock_interview.model.OpenAiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class GptService {

    private final WebClient webClient;

    @Value("${openai.model}")
    private String model;

    public String generateInterviewQuestions(String cvText){
        OpenAiRequest requestBody = new OpenAiRequest(model, "Generate 5 interview questions based on this CV:\n"+cvText, 150, 0.7);


        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
