package net.kuleasycode.tksmartchoice.exception;

import lombok.Data;

@Data
public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	public InternalServerErrorException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
