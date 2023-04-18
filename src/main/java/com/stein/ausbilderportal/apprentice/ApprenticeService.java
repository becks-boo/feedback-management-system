package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class ApprenticeService extends BaseService<Apprentice, UUID, ApprenticeRepository> {
    public ApprenticeService(ApprenticeRepository apprenticeRepository) {
        super(apprenticeRepository);
    }

    public void postApprentice(Apprentice apprentice) {
        repo.save(apprentice);
    }

    public void updateApprentice(Apprentice apprentice) {
        repo.save(apprentice);
    }
}
