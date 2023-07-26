package com.training.micro.service.valiidation;

import com.training.micro.service.HelloWorld;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NotContainsImpl implements ConstraintValidator<NotContainsStr,String> {

    private NotContainsStr anno;

    @Override
    public void initialize(final NotContainsStr anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
        String[] annoValueLoc = anno.value();
        for (String sLoc : annoValueLoc) {
            if (value.contains(sLoc)){
                return false;
            }
        }
        return true;
    }
}
