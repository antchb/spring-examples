package com.antchb.examples.spring.mvc.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.antchb.examples.spring.mvc.validator.PromoCodeConstraintValidator;

@Constraint(validatedBy = PromoCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PromoCode {

    String prefix() default "PROMO";
    
    String message() default "Must start with PROMO";
    
    // Can group related constraints
    Class<?>[] groups() default {};
   
    // Provide custom details about validation failure (severity level, error code, etc.)
    Class<? extends Payload>[] payload() default {};

}
