package com.training.micro.service.valiidation;


import com.training.micro.service.rest.models.Address;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = { NotContainsImpl.class })
public @interface NotContainsStr {

    String[] value();

    String message() default "{jakarta.validation.constraints.NotContains.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
