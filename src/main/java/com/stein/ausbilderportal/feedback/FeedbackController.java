package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.base.BaseController;
import org.springframework.stereotype.Controller;

@Controller
public class FeedbackController extends BaseController<Feedback, FeedbackRepository, FeedbackService> {
    public FeedbackController(FeedbackService feedbackService) {
        super(feedbackService);
    }
}

