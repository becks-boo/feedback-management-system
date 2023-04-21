package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.apprentice.Apprentice;
import com.stein.ausbilderportal.base.BaseController;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.dto.FeedbackRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Controller
public class FeedbackController extends BaseController<Feedback, FeedbackRepository, FeedbackService> {
    public FeedbackController(FeedbackService feedbackService) {
        super(feedbackService);
    }

/*    @GetMapping("/apprentices/{apprenticeId}/categories/{categoryId}/feedbacks/")
    public String getFeedbackByApprenticeIdAndCategoryId(@PathVariable UUID apprenticeId,
                                                                                 @PathVariable UUID categoryId,
                                                                                 Model model) {
        List<Feedback> feedbacks = service.getFeedbackByApprenticeAndCategoryId(apprenticeId, categoryId);
        // TODO: write getCategoryByApprenticeId
//        List<Category> categories = service.
        model.addAttribute("feedbacks", feedbacks);
//        model.addAttribute("categories", categories)

        return "show_feedbacks";
    }*/

    @PostMapping("/api/v1/apprentice/feedback/")
    public ResponseEntity<Feedback> addFeedback(@RequestBody FeedbackRequest feedback) throws Exception {
        return ResponseEntity.ok(service.postFeedback(feedback));
    }
}

