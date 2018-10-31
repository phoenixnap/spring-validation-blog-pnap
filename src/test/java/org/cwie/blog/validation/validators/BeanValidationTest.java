package org.cwie.blog.validation.validators;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.cwie.blog.validation.model.SimpleDto;
import org.junit.Assert;
import org.junit.Test;

public class BeanValidationTest {
    private static Validator validator;
    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Test
    public void testIdValidator() {
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
		Assert.assertTrue(constrains.size() > 0);
		
		for (ConstraintViolation<SimpleDto> constrain : constrains) {
			System.out.println("[" + constrain.getPropertyPath() + "][" + constrain.getMessage() + "]");
		}
    }

    @Test
    public void testCategoryValidator() {
    	final SimpleDto simpleDto = new SimpleDto();
		simpleDto.setId(1);
		simpleDto.setName("Test Name");
		simpleDto.setCategory("simple1");
		simpleDto.setActive(true);
		simpleDto.setOrder("asc");
		simpleDto.setCreatedDatetime(new Date());
		
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.usingContext().getValidator();
		
		Set<ConstraintViolation<SimpleDto>> constrains = validator.validate(simpleDto);
		Assert.assertTrue(constrains.size() > 0);
		
		for (ConstraintViolation<SimpleDto> constrain : constrains) {
			System.out.println("[" + constrain.getPropertyPath() + "][" + constrain.getMessage() + "]");
		}
    }
    

}
