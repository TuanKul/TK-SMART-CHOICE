package net.kuleasycode.tksmartchoice.api.external;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tksmartchoice.api.external.response.AccessTokenResponse;
import net.kuleasycode.tksmartchoice.api.external.response.ProductResponse;
import net.kuleasycode.tksmartchoice.settings.ExternalSetting;
import net.kuleasycode.tksmartchoice.settings.LazadaSetting;

@Component
@Slf4j
public class LazadaApi {

	@Autowired
	private ExternalSetting externalSetting;
	
	public ProductResponse callAPIFromLazada() {
		try {
			LazadaSetting lazadaSetting = externalSetting.getLazada();
			if (StringUtils.isEmpty(lazadaSetting) || StringUtils.isEmpty(lazadaSetting.getAccessTokenUrl())) {
				log.info("External Lazada get setting fail...");
				return null;
			}
			String accessToken = getAccessToken(lazadaSetting.getClientId(), lazadaSetting.getClientSecret());
			HttpEntity<Object> entity = new HttpEntity<>(getHttpHeaders(accessToken));
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProductResponse> response = restTemplate.exchange(lazadaSetting.getLazadaUrl(), HttpMethod.GET, entity, ProductResponse.class);
			log.info("url: " + lazadaSetting.getLazadaUrl());
			log.info("response Lazada: " + response.getBody());
			return response.getBody();
		} catch( Exception e) {
			log.error(e.toString(), e);
			return null;
		}
	}
	
	public String getAccessToken(String clientId, String clientSecret) {
		log.info("External Lazada getAccessToken");
		LazadaSetting lazadaSetting = externalSetting.getLazada();
		if (StringUtils.isEmpty(lazadaSetting) || StringUtils.isEmpty(lazadaSetting.getAccessTokenUrl())) {
			log.info("External Lazada getAccessToken : token url missing from config");
			return null;
		}
		String grantType = "grant_type=" + lazadaSetting.getGrantType();
		try {
			HttpEntity<Object> httpEntity = new HttpEntity<>(grantType,
					getHttpHeadersAccessToken(clientId, clientSecret));
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<AccessTokenResponse> response = restTemplate.exchange(lazadaSetting.getAccessTokenUrl(),
					HttpMethod.POST, httpEntity, AccessTokenResponse.class);
			if (StringUtils.isEmpty(response) || response.getStatusCode() != HttpStatus.OK) {
				return null;
			}
			if (response.getBody() != null) {
				return response.getBody().getAccessToken();
			} else {
				return null;
			}

		} catch (Exception e) {
			log.info("External Lazada->getAccessToken Error: " + e.toString(), e);
			return null;
		}
	}
	
	public HttpHeaders getHttpHeaders(String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.add("Authorization", "Bearer " + accessToken);
		return headers;
	}
	
	private HttpHeaders getHttpHeadersAccessToken(String clientId, String clientSecret) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/x-www-form-urlencoded");
		headers.add("Authorization", "Basic " + encodedClientInfo(clientId, clientSecret));
		return headers;
	}
	
	private String encodedClientInfo(String clientId, String clientSecret){
		String clientInfo = clientId + ":" + clientSecret;
		final byte[] encodedClientInfo = Base64.encodeBase64(clientInfo.getBytes());
		return new String(encodedClientInfo);
	}
}
