package com.bitwise.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bitwise.models.LoginUser;

public class LoginUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return LoginUser.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "userName", "arg1.userName", "username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "arg1.password", "password is required");
	
		LoginUser login = (LoginUser)arg0;
	
		if(login.getUserName()!=""&&login.getPassword()!="")
		{
			if(!login.getUserName().equals("harsh")|| !login.getPassword().equals("harsh"))
			{
				arg1.rejectValue("password", "InvalidValues",
		                new Object[]{"userName"},
		                "Invalid Credentials");
			}
		}
	}

}
