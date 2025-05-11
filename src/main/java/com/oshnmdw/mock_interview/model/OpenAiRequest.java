package com.oshnmdw.mock_interview.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenAiRequest {
    private String model;
    private String prompt;

    @JsonProperty("max_tokens")
    private int maxTokens = 150;

    @JsonProperty("temperature")
    private double temperature = 0.7;
}
