package com.example.LT_Java_Giuaky_2180602594.validator.annotation;

import com.example.LT_Java_Giuaky_2180602594.validator.ValidPhongbanIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPhongbanIdValidator.class)
@Documented
public @interface ValidPhongbanId {
    String message() default "Invalid Phongban ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}