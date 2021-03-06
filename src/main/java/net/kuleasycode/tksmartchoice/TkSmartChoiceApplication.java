package net.kuleasycode.tksmartchoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(value = "net.kuleasycode")
@EntityScan(basePackages = "net.kuleasycode")
@EnableAsync
@EnableScheduling
@EnableResourceServer
@EnableWebSecurity
@EnableDiscoveryClient
@RefreshScope
public class TkSmartChoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkSmartChoiceApplication.class, args);
	}

}
