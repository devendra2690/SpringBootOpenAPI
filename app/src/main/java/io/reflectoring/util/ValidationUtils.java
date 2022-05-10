package io.reflectoring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reflectoring.constant.ErrorCategory;
import io.reflectoring.exceptionhandler.APIGenericValidationError;

public class ValidationUtils {

	private static final Logger log = LoggerFactory.getLogger(ValidationUtils.class);

	public static void getValidationError(ErrorCategory errorCategory, String className) {
		log.error("ClassName :{} {}, Error code: {}, Error message: {}", className,
				ErrorCategory.ValidationError.getMessage(), errorCategory.getCode(), errorCategory.getMessage());
		throw new APIGenericValidationError(ErrorCategory.ValidationError.getCode(),
				ErrorCategory.ValidationError.getMessage(), errorCategory.getCode(), errorCategory.getMessage());
	}
}
