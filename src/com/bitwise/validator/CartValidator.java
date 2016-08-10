package com.bitwise.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.models.Cart;

public class CartValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Cart.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "DELtocartproducts", "arg1.DELtocartproducts", " no product selected");
	}

}
