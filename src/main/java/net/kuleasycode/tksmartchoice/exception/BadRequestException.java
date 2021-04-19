package net.kuleasycode.tksmartchoice.exception;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	public BadRequestException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
