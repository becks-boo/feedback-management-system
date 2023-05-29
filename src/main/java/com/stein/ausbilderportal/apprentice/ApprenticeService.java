package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseService;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.category.CategoryRepository;
import com.stein.ausbilderportal.feedback.Feedback;
import com.stein.ausbilderportal.feedback.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApprenticeService extends BaseService<Apprentice, UUID, ApprenticeRepository> {
    private final FeedbackRepository feedbackRepository;
    private final CategoryRepository categoryRepository;

    public ApprenticeService(ApprenticeRepository apprenticeRepository, FeedbackRepository feedbackRepository, CategoryRepository categoryRepository) {
        super(apprenticeRepository);
        this.feedbackRepository = feedbackRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Feedback> getFeedbackByApprenticeId(UUID apprenticeId) {
        return feedbackRepository.findByApprenticeId(apprenticeId);
    }

    public List<Category> getCategoryByApprenticeId(UUID apprenticeId) {
        return feedbackRepository.findCategoryByApprenticeId(apprenticeId);
    }

    public void postApprentice(Apprentice apprentice) {
        repo.save(apprentice);
    }

    public void updateApprentice(Apprentice apprentice) {
        repo.save(apprentice);
    }
}
