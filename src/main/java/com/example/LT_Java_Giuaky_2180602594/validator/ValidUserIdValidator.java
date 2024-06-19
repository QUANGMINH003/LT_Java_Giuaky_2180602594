package com.example.LT_Java_Giuaky_2180602594.validator;

import com.example.LT_Java_Giuaky_2180602594.validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.example.LT_Java_Giuaky_2180602594.entity.User;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if (user == null)
            return true;
        return user.getId() != null;
    }
}
