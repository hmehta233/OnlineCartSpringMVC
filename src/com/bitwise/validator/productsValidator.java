package com.bitwise.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.models.Products;

public class productsValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Products.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "Allproducts", "arg1.Allproducts","select atleast 1 product");
	}

}
