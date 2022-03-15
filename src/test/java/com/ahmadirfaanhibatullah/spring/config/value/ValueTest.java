/**
 * dana.id.
 * Copyright (c) 2017‐2022 All Rights Reserved.
 */
package com.ahmadirfaanhibatullah.spring.config.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ValueTest.java, v 0.1 2022‐03‐14 16.15 Ahmad Irfaan Hibatullah Exp $$
 */

@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {

    @Autowired
    private TestApplication.ApplicationProperties applicationProperties;

    @Autowired
    private TestApplication.SystemProperties systemProperties;


    @Test
    void testValue() {
        assertEquals("Belajar Spring Boot Config Properties", applicationProperties.getName());
        assertEquals(1, applicationProperties.getVersion());
        assertEquals(false, applicationProperties.isProductionMode() );
    }

    @Test
    void testSystemProperties() {
        assertEquals("/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/Home", systemProperties.getJavaHome());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class SystemProperties {

            @Value("${JAVA_HOME}")
            private String javaHome;
        }

        @Component
        @Getter
        public static class ApplicationProperties {

            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private boolean productionMode;
        }
    }
}