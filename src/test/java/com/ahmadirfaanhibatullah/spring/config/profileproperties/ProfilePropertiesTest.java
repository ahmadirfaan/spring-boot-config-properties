package com.ahmadirfaanhibatullah.spring.config.profileproperties;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ProfilePropertiesTest.java, v 0.1 2022‐03‐15 19.30 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest(classes = ProfilePropertiesTest.TestApplication.class)
@ActiveProfiles({"production", "test"})
public class ProfilePropertiesTest {

    @Autowired
    private TestApplication.ProfileProperties profileProperties;

    @Test
    void nameProfileProperties() {
        assertEquals("default", profileProperties.getDefaultFile());
        assertEquals("test", profileProperties.getTestFile());
        assertEquals("production", profileProperties.getProductionFile());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class ProfileProperties {

            @Value("${profile.default}")
            private String defaultFile;

            @Value("${profile.production}")
            private String productionFile;

            @Value("${profile.test}")
            private String testFile;
        }
    }
}