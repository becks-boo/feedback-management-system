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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
        FeedbackData feedbackData = new FeedbackData();
        List<Category> categoryList = apprenticeService.getCategoryByApprenticeId(apprenticeId);

        model.addAttribute("feedback", feedbackData);
        model.addAttribute("apprenticeId", apprenticeId);
        model.addAttribute("categories", categoryList);

        return "create_feedback";
    }

    @PostMapping("/feedbacks/")
    public String addFeedback(@ModelAttribute FeedbackData feedbackData) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        feedbackData.setUserId(user.getId());
        service.postFeedback(feedbackData);

        return "redirect:/apprentices/" + feedbackData.getApprenticeId() + "/";
    }
}

