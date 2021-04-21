package net.kuleasycode.tksmartchoice.api.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenResponse {

	@JsonProperty("access_token")
	@SerializedName("access_token")
	private String accessToken;

	@JsonProperty("token_type")
	@SerializedName("token_type")
	private String tokenType;

	@JsonProperty("refresh_token")
	@SerializedName("refresh_token")
	private String refreshToken;

	@JsonProperty("expires_in")
	@SerializedName("expires_in")
	private String expiresIn;
	
	@JsonProperty("scope")
	@SerializedName("scope")
	private String scope;
}
