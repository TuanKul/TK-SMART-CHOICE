package net.kuleasycode.tksmartchoice.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("message")
	private String message;
}
