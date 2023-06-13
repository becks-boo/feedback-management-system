package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseService;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.category.CategoryRepository;
import com.stein.ausbilderportal.feedback.Feedback;
import com.stein.ausbilderportal.feedback.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ApprenticeService extends BaseService<Apprentice, UUID, ApprenticeRepository> {
    private final FeedbackRepository feedbackRepository;

    public ApprenticeService(ApprenticeRepository apprenticeRepository, FeedbackRepository feedbackRepository) {
        super(apprenticeRepository);
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getFeedbackByApprenticeId(UUID apprenticeId) {
        return feedbackRepository.findByApprenticeId(apprenticeId);
    }

    public List<Category> getCategoryByApprenticeId(UUID apprenticeId) {
        return feedbackRepository.findCategoryByApprenticeId(apprenticeId);
    }

    public List<Feedback> getFeedbackByApprenticeAndCategory(UUID apprenticeId, UUID categoryId) {
        return feedbackRepository.findByApprenticeId(apprenticeId);
    }

    public void postApprentice(Apprentice apprentice) {
        repo.save(apprentice);
    }

    public void updateApprentice(Apprentice apprentice) {
        repo.save(apprentice);
    }

    public void deleteApprentice(Apprentice apprentice) {
        repo.delete(apprentice);
    }

    public void deleteApprenticeById(UUID id) {
        repo.deleteById(id);
    }
}
