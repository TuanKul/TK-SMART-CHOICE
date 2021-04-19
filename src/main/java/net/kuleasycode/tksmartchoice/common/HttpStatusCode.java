package net.kuleasycode.tksmartchoice.common;

import lombok.Getter;

@Getter
public enum HttpStatusCode {

	_200("200", "OK"),
	_400("400", "Bad Request"),
	_500("500", "Internal Server Error"),
	_404("404", "Not found");
	
	private String code;
	
	private String value;

	private HttpStatusCode(String code, String value) {
		this.code = code;
		this.value = value;
	}
}
