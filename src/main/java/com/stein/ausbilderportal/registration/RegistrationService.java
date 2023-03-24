package com.stein.ausbilderportal.registration;

import com.stein.ausbilderportal.exception.ApiRequestException;
import com.stein.ausbilderportal.registration.token.ConfirmationToken;
import com.stein.ausbilderportal.registration.token.ConfirmationTokenService;
import com.stein.ausbilderportal.user.User;
import com.stein.ausbilderportal.user.UserRole;
import com.stein.ausbilderportal.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.email());

        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid.");
        }

        //        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;

        return userService.signUpUser(
                new User(
                        request.firstName(),
                        request.lastName(),
                        request.email(),
                        request.password(),
                        UserRole.USER
                )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() -> new IllegalStateException("Token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new ApiRequestException("Email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new ApiRequestException("Token expired");
        }

        confirmationTokenService.setConfirmedAt(token);

        userService.enableUser(confirmationToken.getUser().getEmail());

        return "confirmed";
    }
}
