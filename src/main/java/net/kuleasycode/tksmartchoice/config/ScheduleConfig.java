package net.kuleasycode.tksmartchoice.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduleConfig {
	
//    @Scheduled(cron = "0 30 6 * * ?")
	@Scheduled(fixedDelay = 1000 * 60 * 5)
	public void runCreateOrBLockAccount() {
		log.info("create account");
	}
}
