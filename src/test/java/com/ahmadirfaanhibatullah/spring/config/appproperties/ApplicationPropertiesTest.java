package com.ahmadirfaanhibatullah.spring.config.appproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ApplicationPropertiesTest.java, v 0.1 2022‐03‐13 20.42 Ahmad Irfaan Hibatullah Exp $$
 */

@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {

    @Autowired
    private Environment environment;

    @Test
    void testApplicationProperties() {
        String applicationName = environment.getProperty("application.name");
        assertEquals(applicationName, "Belajar Spring Boot Config Properties");
    }

    // Environment juga bisa mengakses ke environment variables di local computer kita
    // dengan menggunaka interface Environment
    @Test
    void testEnvironmentJavaHome() {
        String java_home = environment.getProperty("JAVA_HOME");
        System.out.println(java_home);
        assertNotNull(java_home);
    }

    @SpringBootApplication
    public static class TestApplication {

    }
}