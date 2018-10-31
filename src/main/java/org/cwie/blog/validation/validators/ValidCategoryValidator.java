package org.cwie.blog.validation.validators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCategoryValidator implements ConstraintValidator<ValidCategory, String> {
	private static final Map<String, List<String>> availableCategories;
	
	static {
		availableCategories = new HashMap<>();
		availableCategories.put("simpleDto", Arrays.asList("simple", "advanced"));
	}
	
	private String categoryType;

	public ValidCategoryValidator() {
		
	}
	
	@Override
	public void initialize(ValidCategory constraintAnnotation) {
		this.setCategoryType(constraintAnnotation.categoryType());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		List<String> categories = ValidCategoryValidator.availableCategories.get(categoryType);
		if (categories == null || categories.isEmpty()) {
			return false;
		}
		
		for (String category : categories) {
			if (category.equals(value)) {
				return true;
			}
		}
		
		return false;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
}