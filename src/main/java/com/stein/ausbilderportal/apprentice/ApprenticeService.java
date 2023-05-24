package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseService;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.feedback.Feedback;
import com.stein.ausbilderportal.feedback.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ApprenticeService extends BaseService<Apprentice, UUID, ApprenticeRepository> {
    private final FeedbackRepository feedbackRepository;

    public ApprenticeService(ApprenticeRepository apprenticeRepository, FeedbackRepository feedbackRepository) {
        super(apprenticeRepository);
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getFeedbackByApprenticeId(UUID apprenticeID) {
        return feedbackRepository.findByApprenticeId(apprenticeID);
    }
//
//    public Set<Category> getCategoryByFeedback(List<Feedback> feedbackList) {
//        Set<Category> categorySet = new HashSet<>();
//        for (final Feedback feedback : feedbackList) {
//            categorySet.add(feedback.getCategory());
//        }
//
//        return categorySet;
//    }

    public void postApprentice(Apprentice apprentice) {
        repo.save(apprentice);
    }

    public void updateApprentice(Apprentice apprentice) {
        repo.save(apprentice);
    }
}
