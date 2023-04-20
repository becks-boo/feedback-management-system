package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.apprentice.Apprentice;
import com.stein.ausbilderportal.apprentice.ApprenticeService;
import com.stein.ausbilderportal.base.BaseService;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.category.CategoryService;
import com.stein.ausbilderportal.dto.FeedbackRequest;
import com.stein.ausbilderportal.user.User;
import com.stein.ausbilderportal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeedbackService extends BaseService<Feedback, UUID, FeedbackRepository> {
    private final UserService userService;
    private final ApprenticeService apprenticeService;
    private final CategoryService categoryService;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, UserService userService, ApprenticeService apprenticeService, CategoryService categoryService) {
        super(feedbackRepository);
        this.userService = userService;
        this.apprenticeService = apprenticeService;
        this.categoryService = categoryService;
    }

    public List<Feedback> getFeedbackByApprenticeAndCategoryId(UUID apprenticeId, UUID categoryId) {
        return repo.findByApprenticeIdAndCategoryId(apprenticeId, categoryId);
    }

    public Feedback postFeedback(FeedbackRequest feedback) throws Exception {
        Apprentice apprentice = apprenticeService.get(feedback.apprenticeId());
        Category category = categoryService.get(feedback.categoryId());
        User user = userService.getUser(feedback.userId());

        return repo.save(
                Feedback.builder()
                        .title(feedback.title())
                        .text(feedback.text())
                        .poster(feedback.poster())
                        .apprentice(apprentice)
                        .category(category)
                        .user(user)
                        .build()
        );
    }
}
