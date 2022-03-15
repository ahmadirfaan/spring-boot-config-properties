package com.ahmadirfaanhibatullah.spring.config;

import com.ahmadirfaanhibatullah.spring.config.converter.StringToDateConverter;
import com.ahmadirfaanhibatullah.spring.config.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({
		ApplicationProperties.class
})
public class BelajarSpringConfigPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringConfigPropertiesApplication.class, args);
	}

	@Bean
	public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
		ApplicationConversionService conversionService = new ApplicationConversionService();
		conversionService.addConverter(stringToDateConverter);
		return conversionService;
	}

}
