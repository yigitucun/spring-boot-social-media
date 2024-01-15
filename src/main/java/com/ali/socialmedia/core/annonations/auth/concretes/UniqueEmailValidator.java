package com.ali.socialmedia.core.annonations.auth.concretes;

import com.ali.socialmedia.core.annonations.auth.abstracts.UniqueEmail;
import com.ali.socialmedia.dataAccess.abstracts.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {
    private final IUserRepository userRepository;

    public UniqueEmailValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !this.userRepository.existsByEmail(email);
    }
}
