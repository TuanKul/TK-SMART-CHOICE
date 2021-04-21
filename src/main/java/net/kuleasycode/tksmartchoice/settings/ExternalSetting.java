package net.kuleasycode.tksmartchoice.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "external")
@Data
public class ExternalSetting {

	private LazadaSetting lazada;
	
	private TikiSetting tiki;
	
	private ShopeeSetting shopee;
}
