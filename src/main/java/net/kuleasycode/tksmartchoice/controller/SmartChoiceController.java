package net.kuleasycode.tksmartchoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tksmartchoice.request.SearchProductRequest;
import net.kuleasycode.tksmartchoice.response.ProductResponse;
import net.kuleasycode.tksmartchoice.service.SmartService;
import net.kuleasycode.tksmartchoice.utils.JsonUtils;

@RestController
@Slf4j
public class SmartChoiceController {
	
	@Autowired
	private SmartService smartService;

	@PostMapping(value = "/v1/search-product")
	@PreAuthorize("#oauth2.hasScope('search_product')")
	public ResponseEntity<ProductResponse> searchProductByCriteria(@RequestBody SearchProductRequest request, Pageable pageable) {
		String json = JsonUtils.convertObjectToJsonLog(request);
		log.info("[START] search product with----" + json);
		if (StringUtils.isEmpty(request.validation())) {
			ProductResponse response = smartService.searchProduct(request, pageable);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(request.validation());
	}
}
