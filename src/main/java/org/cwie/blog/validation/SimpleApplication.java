package org.cwie.blog.validation;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.cwie.blog.validation.model.SimpleDto;

public class SimpleApplication {
	public static void main(String[] args) {
		final SimpleDto simpleDto = new SimpleDto();
		simpleDto.setId(-1);
		simpleDto.setName("Test Name");
		simpleDto.setCategory("simple");
		simpleDto.setActive(true);
		simpleDto.setOrder("asc");
		simpleDto.setCreatedDatetime(new Date());
		
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.usingContext().getValidator();
		
		Set<ConstraintViolation<SimpleDto>> constrains = validator.validate(simpleDto);
		for (ConstraintViolation<SimpleDto> constrain : constrains) {
			System.out.println("[" + constrain.getPropertyPath() + "][" + constrain.getMessage() + "]");
		}
	}
}
