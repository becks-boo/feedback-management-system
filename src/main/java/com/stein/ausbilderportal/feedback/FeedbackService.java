package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.apprentice.Apprentice;
import com.stein.ausbilderportal.apprentice.ApprenticeService;
import com.stein.ausbilderportal.base.BaseService;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.category.CategoryService;
import com.stein.ausbilderportal.user.User;
import com.stein.ausbilderportal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeedbackService extends BaseService<Feedback, UUID, FeedbackRepository> {
    @Autowired
    private final UserService userService;
    @Autowired
    private final ApprenticeService apprenticeService;
    @Autowired
    private final CategoryService categoryService;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, UserService userService, ApprenticeService apprenticeService,
                           CategoryService categoryService) {
        super(feedbackRepository);
        this.userService = userService;
        this.apprenticeService = apprenticeService;
        this.categoryService = categoryService;
    }

    public List<Feedback> getFeedbackByApprenticeIdAndCategoryId(UUID apprenticeId, UUID categoryId) {
        return repo.findByApprenticeIdAndCategoryId(apprenticeId, categoryId);
    }

    public void postFeedback(FeedbackData feedbackData) throws Exception {
        Feedback feedback = new Feedback();
        Category category = categoryService.get(feedbackData.getCategoryId());
        Apprentice apprentice = apprenticeService.get(feedbackData.getApprenticeId());
        User user = userService.getUser(feedbackData.getUserId());
        feedback.setApprentice(apprentice);
        feedback.setCategory(category);
        feedback.setUser(user);
        feedback.setTitle(feedbackData.getTitle());
        feedback.setText(feedbackData.getText());

        repo.save(feedback);
    }

/*    public Feedback putFeedback(UUID id, FeedbackRequest feedback) {
        Feedback editedFeedback = this.get(id);
        editedFeedback.setTitle(feedback.title());
        editedFeedback.setText(feedback.text());
        editedFeedback.setPoster(feedback.poster());

        return repo.save(editedFeedback);
    }*/
}
