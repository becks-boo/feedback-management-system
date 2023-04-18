package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseController;
import com.stein.ausbilderportal.exception.ApiRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
public class ApprenticeController extends BaseController<Apprentice, ApprenticeRepository, ApprenticeService>{
    public ApprenticeController(ApprenticeService apprenticeService) {
        super(apprenticeService);
    }

    @GetMapping("/apprentice/{id}/")
    public String showApprentice(@PathVariable UUID id, Model model) {
        model.addAttribute("apprentice", service.get(id));

        return "show-apprentice";
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

    @PostMapping("/api/v1/apprentices/")
    public void onPost(@RequestBody() Optional<Apprentice> apprentice) {
        if (apprentice.isEmpty()) {
            throw new ApiRequestException("Please provide a RequestBody.");
        }

        if (apprentice.get().getFirstName() == null || apprentice.get().getEmail() == null) {
            throw new ApiRequestException("Information still needed.");
        }

        service.postApprentice(apprentice.get());
    }
}
