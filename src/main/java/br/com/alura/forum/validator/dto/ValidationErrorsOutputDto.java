package br.com.alura.forum.validator.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDto {

	private List<String> globalErrorMessage = new ArrayList<>();
	private List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();
	
	public void addError(String message) {
		globalErrorMessage.add(message);
	}
	
	public void addFieldError(String field, String message) {
		FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
		fieldErrors.add(fieldError);
	}
	
	public List<String> getGlobalErrorMessages() {
		return globalErrorMessage;
	}
	
	public List<FieldErrorOutputDto> getErrors() {
		return fieldErrors;
	}
	
	public int getNumberOfErrors() {
		return this.globalErrorMessage.size() + this.fieldErrors.size();
	}
}
