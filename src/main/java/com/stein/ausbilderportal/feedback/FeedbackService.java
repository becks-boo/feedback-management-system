package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FeedbackService extends BaseService<Feedback, UUID, FeedbackRepository> {
    public FeedbackService(FeedbackRepository feedbackRepository) {
        super(feedbackRepository);
    }
}
