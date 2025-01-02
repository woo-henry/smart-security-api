package com.sanesong.security.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebApplication extends SpringBootServletInitializer {
	
	public static void main(final String[] args) {
		final SpringApplication app = new SpringApplication(WebApplication.class);
		app.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}
}
