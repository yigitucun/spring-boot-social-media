package com.ali.socialmedia.core.annonations.auth.abstracts;

import com.ali.socialmedia.core.annonations.auth.concretes.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {
    String message() default "Username already taken";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
