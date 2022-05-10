package io.reflectoring.constant;

public enum ErrorCategory {

    ValidationError("1001", "Data Validation Error"),

	ER0001("ER0001", "InValid Username, No record found with provided username.");

	private String code;
	private String message;

	ErrorCategory(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
