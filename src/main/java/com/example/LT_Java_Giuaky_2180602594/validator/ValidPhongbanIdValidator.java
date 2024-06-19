package com.example.LT_Java_Giuaky_2180602594.validator;

import com.example.LT_Java_Giuaky_2180602594.entity.Phongban;
import com.example.LT_Java_Giuaky_2180602594.validator.annotation.ValidPhongbanId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhongbanIdValidator implements ConstraintValidator<ValidPhongbanId, Phongban> {
    @Override
    public boolean isValid(Phongban phongban, ConstraintValidatorContext context){
        return phongban != null && phongban.getId() != null;
    }
}