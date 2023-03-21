package com.stein.ausbilderportal.registration;

import com.stein.ausbilderportal.user.User;
import com.stein.ausbilderportal.user.UserRole;
import com.stein.ausbilderportal.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid.");
        }

        return userService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
