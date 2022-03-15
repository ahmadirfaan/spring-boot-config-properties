
package com.ahmadirfaanhibatullah.spring.config.configurationproperties;

import com.ahmadirfaanhibatullah.spring.config.converter.StringToDateConverter;
import com.ahmadirfaanhibatullah.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ConfigurationPropertiesTest.java, v 0.1 2022‐03‐15 19.46 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
public class ConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private ConversionService conversionService;

    @Test
    void testConversionService() {
        assertTrue(conversionService.canConvert(String.class, Duration.class));
        assertTrue(conversionService.canConvert(String.class, Date.class));

        Duration result = conversionService.convert("10s", Duration.class);
        assertEquals(Duration.ofSeconds(10), result);
    }

    @Test
    void testConfigurationProperties() {
        assertEquals("Belajar Spring Boot Config Properties", applicationProperties.getName());
        assertEquals(1, applicationProperties.getVersion());
        assertFalse(applicationProperties.isProductionMode());
    }

    @Test
    void testDatabaseProperties() {
        assertEquals("ahmadirfaan", applicationProperties.getDatabaseProperties().getUsername());
        assertEquals("P@ssw0rd", applicationProperties.getDatabaseProperties().getPassword());
        assertEquals("belajar", applicationProperties.getDatabaseProperties().getDatabase());
        assertEquals("jdbc:contoh", applicationProperties.getDatabaseProperties().getUrl());
    }

    @Test
    void testCollection() {
        assertEquals(Arrays.asList("products", "customers", "categories"), applicationProperties.getDatabaseProperties().getWhitelistTables());


        assertEquals(100, applicationProperties.getDatabaseProperties().getMaxTablesSize().get("products"));
        assertEquals(100, applicationProperties.getDatabaseProperties().getMaxTablesSize().get("customers"));
        assertEquals(100, applicationProperties.getDatabaseProperties().getMaxTablesSize().get("categories"));
    }

    @Test
    void testRoles() {
        assertEquals(Arrays.asList(new ApplicationProperties.Role("default", "Default Role"), new ApplicationProperties.Role("guest", "Guest Role")), applicationProperties.getDefaultRoles());

        assertEquals("default", applicationProperties.getDefaultRoles().get(0).getId());
        assertEquals("Default Role", applicationProperties.getDefaultRoles().get(0).getName());
        assertEquals("guest", applicationProperties.getDefaultRoles().get(1).getId());
        assertEquals("Guest Role", applicationProperties.getDefaultRoles().get(1).getName());

        assertEquals("admin", applicationProperties.getRoles().get("admin").getId());
        assertEquals("Admin Role", applicationProperties.getRoles().get("admin").getName());
        assertEquals("finance", applicationProperties.getRoles().get("finance").getId());
        assertEquals("Finance Role", applicationProperties.getRoles().get("finance").getName());
    }

    @Test
    void testDuration() {
        assertEquals(Duration.ofSeconds(10), applicationProperties.getDefaultTimeout());
    }

    @Test
    void testCustomConverter() {
        Date expireDate = applicationProperties.getExpireDate();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("2022-08-22", simpleDateFormat.format(expireDate));
    }

    @SpringBootApplication
    @EnableConfigurationProperties(value = {
            ApplicationProperties.class
    })
    @Import(StringToDateConverter.class)
    public static class TestApplication {

        @Bean
        public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
            ApplicationConversionService conversionService = new ApplicationConversionService();
            conversionService.addConverter(stringToDateConverter);
            return conversionService;
        }

    }
}