package com.bank.customer.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
@Component
public class EnumGenderPatternValidator implements ConstraintValidator<EnumGenderPattern, Enum<?>> {

	private Pattern pattern;

	@Override
	public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
		if (value == null) {
            return true;
        }

        Matcher m = pattern.matcher(value.name());
        return m.matches();
	}
	
    public void initialize(EnumGenderPattern annotation) {
        try {
            pattern = Pattern.compile(annotation.regexp());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

}
