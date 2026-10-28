
package com.feedback.backend.controller;

import com.feedback.backend.entity.Feedback;
import com.feedback.backend.repository.FeedbackRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = {
    "http://localhost:5500",
    "http://127.0.0.1:5500",
    "http://localhost:5501",
    "http://127.0.0.1:5501"
})
public class FeedbackController {

    private final FeedbackRepository repository;

    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> saveFeedback(
            @RequestBody Feedback feedback) {

        if (feedback.getStudentName() == null
                || feedback.getStudentName().isBlank()
                || feedback.getRegisterNumber() == null
                || feedback.getRegisterNumber().isBlank()
                || feedback.getFacultyName() == null
                || feedback.getFacultyName().isBlank()) {

            return ResponseEntity.badRequest().body(
                Map.of("message",
                    "Please fill in all student and faculty details.")
            );
        }

        Integer[] ratings = {
            feedback.getQ1(), feedback.getQ2(),
            feedback.getQ3(), feedback.getQ4(),
            feedback.getQ5(), feedback.getQ6(),
            feedback.getQ7(), feedback.getQ8(),
            feedback.getQ9(), feedback.getQ10()
        };

        for (Integer rating : ratings) {
            if (rating == null || rating < 1 || rating > 5) {
                return ResponseEntity.badRequest().body(
                    Map.of("message",
                        "All 10 ratings must be between 1 and 5.")
                );
            }
        }

        Feedback saved = repository.save(feedback);

        return ResponseEntity.ok(
            Map.of("message", "Feedback saved successfully.",
                   "id", saved.getId())
        );
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }
}
