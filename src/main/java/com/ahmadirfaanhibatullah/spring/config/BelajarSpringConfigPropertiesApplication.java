package com.ahmadirfaanhibatullah.spring.config;

import com.ahmadirfaanhibatullah.spring.config.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class BelajarSpringConfigPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringConfigPropertiesApplication.class, args);
	}

}
