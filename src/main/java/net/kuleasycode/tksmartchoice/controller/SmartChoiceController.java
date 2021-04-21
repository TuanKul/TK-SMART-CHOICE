package net.kuleasycode.tksmartchoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tksmartchoice.request.SearchProductRequest;
import net.kuleasycode.tksmartchoice.response.ProductResponse;
import net.kuleasycode.tksmartchoice.service.SearchHistoryService;
import net.kuleasycode.tksmartchoice.service.SmartService;
import net.kuleasycode.tksmartchoice.utils.JsonUtils;

@RestController
@Slf4j
public class SmartChoiceController {
	
	@Autowired
	private SmartService smartService;
	
	@Autowired
	private SearchHistoryService searchHistoryService;

	@GetMapping(value = "/v1/search-product")
	@PreAuthorize("#oauth2.hasScope('search_product')")
	public ResponseEntity<ProductResponse> searchProductByCriteria(@RequestParam("search_value") String searchValue,
		@RequestParam("end_date") String endDate, @RequestParam("start_date") String startDate, Pageable pageable) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userRequest = "";
		if (auth != null) {
			OAuth2Request oauth2 = ((OAuth2Authentication) auth).getOAuth2Request();
			userRequest = oauth2.getClientId();
		}
		SearchProductRequest request = new SearchProductRequest(searchValue, startDate, endDate);
		String json = JsonUtils.convertObjectToJsonLog(request);
		searchHistoryService.saveLog(json, pageable,userRequest);
		log.info("[START] search product with----" + json);
		if (StringUtils.isEmpty(request.validation())) {
			ProductResponse response = smartService.searchProduct(request, pageable);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(request.validation());
	}
}
