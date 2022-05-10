package io.reflectoring.exceptionhandler;

import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

	@ExceptionHandler(value = APIGenericValidationError.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorType.Error handleFieldValidationError(
			APIGenericValidationError apiGenericValidationError, WebRequest webRequest) {

		log.error("Log Root cause in handleFieldValidationError "
				+ ExceptionUtils.getRootCause(apiGenericValidationError));
		
		ErrorType.Error error = new ErrorType.Error();
		error.setDeveloperMessage(apiGenericValidationError.getErrorMessage());
		error.setCode(apiGenericValidationError.getCode());
		error.setMessage(apiGenericValidationError.getMessage());
		error.setTimestamp(new Date().toString());
		error.setStatus(Integer.toString(HttpStatus.BAD_REQUEST.value()));
		
		return error;
	}
}
