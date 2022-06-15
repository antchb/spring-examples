package com.antchb.examples.spring.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.antchb.examples.spring.mvc.model.PromoCode;

public class PromoCodeConstraintValidator implements ConstraintValidator<PromoCode, String> {

    private String prefix;

    @Override
    public void initialize(PromoCode promoCode) {
        prefix = promoCode.prefix();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || (value.length() > prefix.length() && value.startsWith(prefix));
    }

}
