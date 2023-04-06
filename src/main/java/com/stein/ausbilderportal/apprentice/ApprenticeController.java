package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseController;
import com.stein.ausbilderportal.exception.ApiRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/v1/apprentices")
public class ApprenticeController extends BaseController<Apprentice, ApprenticeRepository, ApprenticeService>{
    public ApprenticeController(ApprenticeService apprenticeService) {
        super(apprenticeService);
    }

    @GetMapping("/")
    public String listApprentices(Model model) {
        model.addAttribute("apprentices", service.getAll());

        return "apprentices";
    }

    @PostMapping()
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
