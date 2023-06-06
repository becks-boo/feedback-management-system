package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseController;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.feedback.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ApprenticeController extends BaseController<Apprentice, ApprenticeRepository, ApprenticeService>{
    public ApprenticeController(ApprenticeService apprenticeService) {
        super(apprenticeService);
    }

    @GetMapping("/apprentices/{id}/")
    public String showApprentice(@PathVariable UUID id, Model model) {
        model.addAttribute("apprentice", service.get(id));

        List<Feedback> feedbackList = service.getFeedbackByApprenticeId(id);
        model.addAttribute("feedbacks", feedbackList);

        List<Category> categoryList = service.getCategoryByApprenticeId(id);
        model.addAttribute("categories", categoryList);

        return "show_apprentice";
    }

    @GetMapping("/apprentices/")
    public String listApprentices(Model model) {
        model.addAttribute("apprentices", service.getAll());

        return "apprentices";
    }

    @GetMapping("/apprentices/new/")
    public String createApprenticeForm(Model model) {
        Apprentice apprentice = new Apprentice();
        model.addAttribute("apprentice", apprentice);

        return "create_apprentice";
    }

    @PostMapping("/apprentices/")
    public String addApprentice(@ModelAttribute("apprentice") Apprentice apprentice) {
        service.postApprentice(apprentice);

        return "redirect:/apprentices/";
    }

    @GetMapping("/apprentices/edit/{id}")
    public String editApprenticeForm(@PathVariable UUID id, Model model) {
        model.addAttribute("apprentice", service.get(id));

        return "edit_apprentice";
    }

    @PostMapping("/apprentices/{id}")
    public String editApprentice(@PathVariable UUID id, @ModelAttribute("apprentice") Apprentice apprentice) {
        Apprentice existingApprentice = service.get(id);
        // TODO: Not necessary
        existingApprentice.setId(id);
        existingApprentice.setFirstName(apprentice.getFirstName());
        existingApprentice.setEmail(apprentice.getEmail());

        service.updateApprentice(existingApprentice);

        return "redirect:/apprentices/";
    }

    @DeleteMapping("/apprentices/{id}")
    public String deleteApprentice(@PathVariable UUID id) {
        service.deleteApprenticeById(id);

        return "redirect:/apprentices/";
    }
}
