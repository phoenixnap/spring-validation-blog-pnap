package org.cwie.blog.validation.validators;

import java.util.Date;

import org.cwie.blog.validation.model.SimpleDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SpringSimpleDtoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SimpleDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 if (errors.getErrorCount() == 0) {
			 SimpleDto param = (SimpleDto) target;
			 Date now = new Date();
			 if (param.getCreatedDatetime() == null) {
				 errors.reject("100", "Create Date Time can't be null");
			 } else if (now.before(param.getCreatedDatetime())) {
				 errors.reject("101", "Create Date Time can't be bigger than current date time");
			 }
		 }
	}

}
