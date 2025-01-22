package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to validate that the client is from Greece and at least 18 years old.
 */
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClientValidator.class)
public @interface ValidClient {

    String message() default "Client must be from Greece and at least 18 years old.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
