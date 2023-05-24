package com.stein.ausbilderportal.feedback;

import com.fasterxml.jackson.annotation.JsonValue;
import com.stein.ausbilderportal.apprentice.Apprentice;
import com.stein.ausbilderportal.base.BaseController;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.dto.FeedbackRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class FeedbackController extends BaseController<Feedback, FeedbackRepository, FeedbackService> {
    public FeedbackController(FeedbackService feedbackService) {
        super(feedbackService);
    }

    @GetMapping(value = "/api/v1/apprentices/{apprenticeId}/categories/{categoryId}/feedbacks/")
    public ResponseEntity<List<Feedback>> getFeedbackByApprenticeIdAndCategoryId(@PathVariable UUID apprenticeId,
                                                                 @PathVariable UUID categoryId) {
        List<Feedback> feedbacks = service.getFeedbackByApprenticeIdAndCategoryId(apprenticeId, categoryId);

        return ResponseEntity.ok(feedbacks);
    }

    @PostMapping("/api/v1/apprentices/feedbacks/")
    public ResponseEntity<Feedback> addFeedback(@RequestBody FeedbackRequest feedback) throws Exception {
        return ResponseEntity.ok(service.postFeedback(feedback));
    }

    @PutMapping("/api/v1/feedbacks/{id}/")
    public ResponseEntity<Feedback> editFeedback(@PathVariable UUID id, @RequestBody FeedbackRequest feedback) {
        return ResponseEntity.ok(service.putFeedback(id, feedback));
    }
}

