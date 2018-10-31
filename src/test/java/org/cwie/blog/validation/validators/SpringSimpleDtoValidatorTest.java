package org.cwie.blog.validation.validators;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.cwie.blog.validation.Application;
import org.cwie.blog.validation.model.SimpleDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringSimpleDtoValidatorTest {
	private static final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

	@Autowired
	private SpringSimpleDtoValidator springSimpleDtoValidator;

	static {
		messageSource.setBasename("message");
	}

	@Test
	public void testValidate() {
		final SimpleDto simpleDto = new SimpleDto();
		simpleDto.setId(1);
		simpleDto.setName("Test Name");
		simpleDto.setCategory("simple1");
		simpleDto.setActive(true);
		simpleDto.setOrder("asc");
		simpleDto.setCreatedDatetime(new Date(2019, 0, 1));

		final DataBinder dataBinder = new DataBinder(simpleDto);
		dataBinder.addValidators(springSimpleDtoValidator);
		dataBinder.validate();

		Assert.assertTrue(dataBinder.getBindingResult().hasErrors());

		if (dataBinder.getBindingResult().hasErrors()) {
			List<ObjectError> objectErrors = dataBinder.getBindingResult().getAllErrors();
			for (ObjectError objectError : objectErrors) {
				System.out.println("ERROR [" + objectError.getObjectName() + "][" + objectError.getCode() + "][" + messageSource.getMessage(objectError, Locale.getDefault()) + "]");
			}
			
		}
	}
}


