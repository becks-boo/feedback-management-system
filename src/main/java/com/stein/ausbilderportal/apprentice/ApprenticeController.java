package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseController;
import com.stein.ausbilderportal.exception.ApiRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/apprentice")
public class ApprenticeController extends BaseController<Apprentice, ApprenticeRepository, ApprenticeService> {
    public ApprenticeController(ApprenticeService apprenticeService) {
        super(apprenticeService);
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
