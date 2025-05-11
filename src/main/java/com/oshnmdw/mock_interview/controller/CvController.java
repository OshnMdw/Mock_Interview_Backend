package com.oshnmdw.mock_interview.controller;

import com.oshnmdw.mock_interview.service.CvParserService;
import com.oshnmdw.mock_interview.service.GptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cv")
@RequiredArgsConstructor
public class CvController {

    private final CvParserService cvParserService;
    private final GptService gptService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCv(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("File name : " + file.getOriginalFilename());
            String text = cvParserService.extractText(file);
            System.out.println("Text : " + text);
            String questions = gptService.generateInterviewQuestions(text);
            return ResponseEntity.ok(questions);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error : " + e.getMessage());
        }
    }
}
