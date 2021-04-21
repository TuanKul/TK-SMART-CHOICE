package net.kuleasycode.tksmartchoice.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tksmartchoice.api.external.LazadaApi;
import net.kuleasycode.tksmartchoice.api.external.ShopeeApi;
import net.kuleasycode.tksmartchoice.api.external.TikiApi;
import net.kuleasycode.tksmartchoice.api.external.response.ProductResponse;
import net.kuleasycode.tksmartchoice.common.Constant;
import net.kuleasycode.tksmartchoice.converter.ProductConverter;
import net.kuleasycode.tksmartchoice.dto.ProductDto;
import net.kuleasycode.tksmartchoice.repository.ProductRepository;

@Component
@Slf4j
@Transactional
public class ScheduleConfig {
	
	@Autowired
	private TikiApi tikiApi;
	
	@Autowired
	private ShopeeApi shoppeApi;

	@Autowired
	private LazadaApi lazadaApi;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
//    @Scheduled(cron = "0 30 6 * * ?")
	@Scheduled(fixedDelay = 1000 * 60 * 5)
	public void getAllProductFromTiki() {
		try {
			log.info("[START] get all product from TIKI");
			ProductResponse tiki = tikiApi.callAPIFromTiki();
			if(!StringUtils.isEmpty(tiki)) {
				tiki.getListProductDetail().stream().forEach(tikiValue -> 
					productRepository.save(productConverter.convertDtoToEntity(new ProductDto(tikiValue, Constant.TIKI))));
			}
			log.info("[END] get all product from TIKI");
		} catch (Exception e) {
			log.error("[EXCEPTION] scheduler Tiki--", e);
		}
	}
	
	@Scheduled(fixedDelay = 1000 * 60 * 5)
	public void getAllProductFromLazada() {
		try {
			log.info("[START] get all product from LAZADA");
			ProductResponse lazada = lazadaApi.callAPIFromLazada();
			if(!StringUtils.isEmpty(lazada)) {
				lazada.getListProductDetail().stream().forEach(lazadaValue -> 
					productRepository.save(productConverter.convertDtoToEntity(new ProductDto(lazadaValue, Constant.LAZADA))));
			}
			log.info("[END] get all product from LAZADA");
		} catch (Exception e) {
			log.error("[EXCEPTION] scheduler Lazada--", e);
		}
	}
	
	@Scheduled(fixedDelay = 1000 * 60 * 5)
	public void getAllProductFromShopee() {
		try {
			log.info("[START] get all product from SHOPEE");
			ProductResponse shopee = shoppeApi.callAPIFromShopee();
			if(!StringUtils.isEmpty(shopee)) {
				shopee.getListProductDetail().stream().forEach(shopeeValue -> 
					productRepository.save(productConverter.convertDtoToEntity(new ProductDto(shopeeValue, Constant.SHOPEE))));
			}
			log.info("[END] get all product from SHOPEE");
		} catch (Exception e) {
			log.error("[EXCEPTION] scheduler Shopee--", e);
		}
		
	}
}
