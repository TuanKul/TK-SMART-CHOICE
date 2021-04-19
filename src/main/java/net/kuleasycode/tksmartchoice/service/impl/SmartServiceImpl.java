package net.kuleasycode.tksmartchoice.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tksmartchoice.common.HttpStatusCode;
import net.kuleasycode.tksmartchoice.converter.ProductConverter;
import net.kuleasycode.tksmartchoice.dto.ProductDto;
import net.kuleasycode.tksmartchoice.entity.ProductEntity;
import net.kuleasycode.tksmartchoice.exception.InternalServerErrorException;
import net.kuleasycode.tksmartchoice.repository.ProductRepository;
import net.kuleasycode.tksmartchoice.request.SearchProductRequest;
import net.kuleasycode.tksmartchoice.response.Pagination;
import net.kuleasycode.tksmartchoice.response.ProductDetailsResponse;
import net.kuleasycode.tksmartchoice.response.ProductResponse;
import net.kuleasycode.tksmartchoice.service.SmartService;
import net.kuleasycode.tksmartchoice.utils.ValidationUtils;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class SmartServiceImpl implements SmartService {

	private final ProductRepository productRepository;
	private final ProductConverter productConverter;

	@Override
	public ProductResponse searchProduct(SearchProductRequest request, Pageable pageable) {
		try {
			Date startDate = ValidationUtils.parseDate(request.getStartDate());
			Date endDate = ValidationUtils.parseDate(request.getEndDate());
			Page<ProductEntity> pageProducts = productRepository.findAllByProductNameFromDateLessThanEqualAndValidToDateGreaterThanEqual(request.getSearchValue(), startDate, endDate, pageable);
			
			List<ProductDto> listDto = pageProducts.getContent().stream().map(entity -> productConverter.convertEntityToDto(entity)).collect(Collectors.toList());
			
			List<ProductDetailsResponse> listResult = listDto.stream().map(detail -> new ProductDetailsResponse(detail)).collect(Collectors.toList());
			
			ProductResponse response = new ProductResponse(HttpStatusCode._200.getCode(), HttpStatusCode._200.getValue());
			Pagination pagination = new Pagination(pageProducts.getNumber(), pageProducts.getSize(), pageProducts.getTotalPages(), pageProducts.getTotalElements());
			response.setListProductDetail(listResult);
			response.setPagination(pagination);
			return response;
		} catch (Exception e) {
			log.info("[EXCEPTION]" + e.toString(), e);
			throw new InternalServerErrorException(HttpStatusCode._500.getCode(), HttpStatusCode._500.getValue());
		}
	}

}