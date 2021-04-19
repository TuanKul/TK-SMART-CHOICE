package net.kuleasycode.tksmartchoice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tksmartchoice.common.HttpStatusCode;
import net.kuleasycode.tksmartchoice.exception.BadRequestException;
import net.kuleasycode.tksmartchoice.exception.InternalServerErrorException;
import net.kuleasycode.tksmartchoice.response.BaseResponse;

@RestControllerAdvice
@Slf4j
@EnableWebMvc
public class AdviceController {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BaseResponse> handleBadRequest(BadRequestException exception) {
		BaseResponse result = new BaseResponse(exception.getErrorCode(), exception.getErrorMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<BaseResponse> handleInternalServerError(InternalServerErrorException exception) {
		BaseResponse result = new BaseResponse(exception.getErrorCode(), exception.getErrorMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<BaseResponse> handleNotFound(NoHandlerFoundException exception, WebRequest request) {
		log.error("request 404" + exception);
		BaseResponse result = new BaseResponse(HttpStatusCode._404.getCode(), "URL " + exception.getHttpMethod() + " " + exception.getRequestURL() + " not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<BaseResponse> handleAllErrorException(Throwable exception) {
		log.error("Exception..." + exception.toString(), exception);
		BaseResponse result = new BaseResponse(HttpStatusCode._500.getCode(), HttpStatusCode._500.getValue());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	}
	
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public ResponseEntity<BaseResponse> handleNoHandlerFoundException(
//			NoHandlerFoundException noHandlerFoundException) {
//
//		log.error("No handler found for url request from client.", noHandlerFoundException);
//		log.info(noHandlerFoundException.getMessage());
//		log.info(noHandlerFoundException.getLocalizedMessage());
//
//		BaseResponse fullResponse = new BaseResponse();
//		fullResponse.setCode("URL_NOT_FOUND");
//		fullResponse
//				.setMessage("The url '" + noHandlerFoundException.getRequestURL() + "' not found.");
//
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fullResponse);
//	}
}
