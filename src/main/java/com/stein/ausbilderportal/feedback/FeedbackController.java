package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.apprentice.Apprentice;
import com.stein.ausbilderportal.apprentice.ApprenticeRepository;
import com.stein.ausbilderportal.apprentice.ApprenticeService;
import com.stein.ausbilderportal.base.BaseController;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.category.CategoryRepository;
import com.stein.ausbilderportal.category.CategoryService;
import com.stein.ausbilderportal.user.User;
import com.stein.ausbilderportal.user.UserService;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class FeedbackController extends BaseController<Feedback, FeedbackRepository, FeedbackService> {

    private final UserService userService;
    private final ApprenticeService apprenticeService;
    private final CategoryService categoryService;

    public FeedbackController(FeedbackService feedbackService, ApprenticeRepository apprenticeRepository, CategoryRepository categoryRepository, UserService userService, ApprenticeService apprenticeService, CategoryService categoryService) {
        super(feedbackService);
        this.userService = userService;
        this.apprenticeService = apprenticeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/apprentices/{apprenticeId}/feedbacks/new/")
    public String createFeedbackFormForApprentice(@PathVariable UUID apprenticeId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Feedback feedback = new Feedback();
        List<Category> categoryList = apprenticeService.getCategoryByApprenticeId(apprenticeId);

        model.addAttribute("userId", user.getId());
        model.addAttribute("feedback", feedback);
        model.addAttribute("apprenticeId", apprenticeId);
        model.addAttribute("categories", categoryList);

        return "create_feedback";
    }

    @PostMapping("/feedbacks/{apprenticeId}/{categoryId}/")
    public String addFeedback(@ModelAttribute("feedback") Feedback feedback,
                              @PathVariable UUID apprenticeId,
                              @RequestParam UUID categoryId) {
        Apprentice apprentice = apprenticeService.get(apprenticeId);
        Category category = categoryService.get(categoryId);

        feedback.setApprentice(apprentice);
        feedback.setCategory(category);

        service.postFeedback(feedback);

        return "redirect:/apprentices/";
    }

/*    @GetMapping(value = "/api/v1/apprentices/{apprenticeId}/categories/{categoryId}/feedbacks/")
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
    }*/
}

