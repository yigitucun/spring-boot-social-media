package com.ali.socialmedia.core.annonations.auth.concretes;

import com.ali.socialmedia.core.annonations.auth.abstracts.UniqueUsername;
import com.ali.socialmedia.dataAccess.abstracts.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    private final IUserRepository userRepository;

    public UniqueUsernameValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !this.userRepository.existsByUsername(username);
    }
}
