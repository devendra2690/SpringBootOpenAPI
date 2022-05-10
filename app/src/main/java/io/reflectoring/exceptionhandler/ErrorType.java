package io.reflectoring.exceptionhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class ErrorType {

	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "Code", "Field", "Message" })
	public static class Errors {

		@JsonProperty("Code")
		private String code;
		@JsonProperty("Field")
		private String field;
		@JsonProperty("Message")
		private String message;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap();

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Map<String, Object> getAdditionalProperties() {
			return additionalProperties;
		}

		public void setAdditionalProperties(Map<String, Object> additionalProperties) {
			this.additionalProperties = additionalProperties;
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "Code", "Type", "Message", "DeveloperMessage", "MoreInfo", "Timestamp", "Status", "Errors" })
	public static class Error {

		@JsonProperty("Code")
		private String code;
		@JsonProperty("Type")
		private String type;
		@JsonProperty("Message")
		private String message;
		@JsonProperty("DeveloperMessage")
		private String developerMessage;
		@JsonProperty("MoreInfo")
		private String moreInfo;
		@JsonProperty("Timestamp")
		private String timestamp;
		@JsonProperty("Status")
		private String status;
		@JsonProperty("Errors")
		private List<Errors> errors = null;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDeveloperMessage() {
			return developerMessage;
		}

		public void setDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
		}

		public String getMoreInfo() {
			return moreInfo;
		}

		public void setMoreInfo(String moreInfo) {
			this.moreInfo = moreInfo;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<Errors> getErrors() {
			return errors;
		}

		public void setErrors(List<Errors> errors) {
			this.errors = errors;
		}

		public Map<String, Object> getAdditionalProperties() {
			return additionalProperties;
		}

		public void setAdditionalProperties(Map<String, Object> additionalProperties) {
			this.additionalProperties = additionalProperties;
		}

	}
}
