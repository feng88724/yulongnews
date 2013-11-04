package com.yulong.news.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yulong.news.bean.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (user.getUserId() == null) {
			errors.rejectValue("userId", "user.not.empty");
		}
	}
}
