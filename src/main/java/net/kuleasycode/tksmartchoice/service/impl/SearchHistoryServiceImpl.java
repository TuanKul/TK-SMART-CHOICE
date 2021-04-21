package net.kuleasycode.tksmartchoice.service.impl;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.kuleasycode.tksmartchoice.converter.SearchHistoryConverter;
import net.kuleasycode.tksmartchoice.dto.SearchHistoryDto;
import net.kuleasycode.tksmartchoice.repository.SearchHistoryRepository;
import net.kuleasycode.tksmartchoice.service.SearchHistoryService;

@Service
@Slf4j
public class SearchHistoryServiceImpl implements SearchHistoryService{
	
	@Autowired
	private SearchHistoryRepository searchHistoryRepository;

	@Autowired
	private SearchHistoryConverter searchHistoryConverter;
	
	@Override
	@Async
	public void saveLog(String request, Pageable pageable, String userRequest) {
		try {
			String requestBody = request + pageable;
			log.info("[START] insert log" + requestBody);
			SearchHistoryDto dto = new SearchHistoryDto(UUID.randomUUID().toString(), requestBody, userRequest);
			dto.setCreatedDate(LocalDate.now());
			dto.setUpdatedDate(LocalDate.now());
			searchHistoryRepository.save(searchHistoryConverter.convertDtoToEntity(dto));
			log.info("[DONE] insert log" + requestBody);
		} catch (Exception e) {
			log.error("[EXCEPTION]" + e.toString(), e);
		}
	}
}
