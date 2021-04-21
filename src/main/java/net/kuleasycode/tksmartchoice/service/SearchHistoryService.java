package net.kuleasycode.tksmartchoice.service;

import org.springframework.data.domain.Pageable;

public interface SearchHistoryService {

	public void saveLog(String request, Pageable pageable, String userRequest);
}
