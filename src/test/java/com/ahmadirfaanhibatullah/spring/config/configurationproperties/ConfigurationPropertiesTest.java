/**
 * dana.id.
 * Copyright (c) 2017‐2022 All Rights Reserved.
 */
package com.ahmadirfaanhibatullah.spring.config.configurationproperties;

import com.ahmadirfaanhibatullah.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ConfigurationPropertiesTest.java, v 0.1 2022‐03‐15 19.46 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
public class ConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties applicationProperties;


    @Test
    void testConfigurationProperties() {
        assertEquals("Belajar Spring Boot Config Properties", applicationProperties.getName());
        assertEquals(1, applicationProperties.getVersion());
        assertFalse(applicationProperties.isProductionMode());
    }

    @SpringBootApplication
    @EnableConfigurationProperties(value = {
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}