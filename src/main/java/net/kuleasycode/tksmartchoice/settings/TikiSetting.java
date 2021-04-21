package net.kuleasycode.tksmartchoice.settings;

import lombok.Data;

@Data
public class TikiSetting {
	
	private String accessTokenUrl;
	
	private String clientId;
	
	private String clientSecret;
	
	private String grantType;
	
	private String tikiUrl;
}
