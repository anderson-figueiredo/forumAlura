package br.com.alura.forum.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.forum.validator.dto.ValidationErrorsOutputDto;

@RestControllerAdvice
public class ValidationErrorHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception) {

		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		ValidationErrorsOutputDto validationErrorsOutputDto = new ValidationErrorsOutputDto();
		
		globalErrors.forEach(error -> validationErrorsOutputDto.addError(getErrorMessage(error)));
		
		fieldErrors.forEach(error -> {
			String errorMessage = getErrorMessage(error);
			validationErrorsOutputDto.addFieldError(error.getField(), errorMessage);
		});
		
		return validationErrorsOutputDto;
	}

	private String getErrorMessage(ObjectError error) {
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}
}
