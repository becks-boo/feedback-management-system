package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.base.BaseController;
import com.stein.ausbilderportal.dto.FeedbackRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FeedbackController extends BaseController<Feedback, FeedbackRepository, FeedbackService> {
    public FeedbackController(FeedbackService feedbackService) {
        super(feedbackService);
    }

    @PostMapping("/api/v1/apprentice/feedback/")
    public ResponseEntity<Feedback> addFeedback(@RequestBody FeedbackRequest feedback) throws Exception {
        return ResponseEntity.ok(service.postFeedback(feedback));
    }
}

