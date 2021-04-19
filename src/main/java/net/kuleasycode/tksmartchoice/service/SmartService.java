package net.kuleasycode.tksmartchoice.service;

import org.springframework.data.domain.Pageable;

import net.kuleasycode.tksmartchoice.request.SearchProductRequest;
import net.kuleasycode.tksmartchoice.response.ProductResponse;

public interface SmartService {

	public ProductResponse searchProduct(SearchProductRequest request, Pageable pageable);
}
