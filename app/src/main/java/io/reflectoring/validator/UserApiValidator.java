package io.reflectoring.validator;

import org.apache.commons.lang3.StringUtils;

import io.reflectoring.constant.ErrorCategory;
import io.reflectoring.util.ValidationUtils;

public class UserApiValidator {
	
	public static void validateUserGetRequest(String loginName, String className) {

		if (StringUtils.isEmpty(loginName) 
				|| loginName.equals(null) 
				|| loginName.trim().equals("")
				|| loginName.equals("null")) {
			ValidationUtils.getValidationError(ErrorCategory.ER0001, className);
		}
	}
}
