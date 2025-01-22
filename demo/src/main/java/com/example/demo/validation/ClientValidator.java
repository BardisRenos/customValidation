package com.example.demo.validation;

import com.example.demo.domain.Client;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientValidator implements ConstraintValidator<ValidClient, Client> {

    @Override
    public boolean isValid(Client client, ConstraintValidatorContext context) {
        if (client == null) {
            return true;
        }

        boolean isFromGreece = "Greece".equalsIgnoreCase(client.getNationality());
        boolean isAtLeast18 = client.getAge() >= 18;

        if (!isFromGreece || !isAtLeast18) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Client must be from Greece and at least 18 years old.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
