package com.oshnmdw.mock_interview.controller;

import com.oshnmdw.mock_interview.service.CvParserService;
import com.oshnmdw.mock_interview.service.GptMockService;
import com.oshnmdw.mock_interview.service.GptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
@RequiredArgsConstructor
public class CvController {

    private final CvParserService cvParserService;
    private final GptMockService gptService;

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadCv(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("File name : " + file.getOriginalFilename());
            String text = cvParserService.extractText(file);
//            String questions = gptService.generateInterviewQuestions(text);
            List<String> questions = gptService.generateInterviewQuestions(text);
            return ResponseEntity.ok(questions);
        } catch (Exception e){
            return null;
        }
    }
}
