package com.ahmadirfaanhibatullah.spring.config.profileenvironment;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ProfileEnvironmentTest.java, v 0.1 2022‐03‐15 09.52 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest(classes = ProfileEnvironmentTest.TestApplication.class)
@ActiveProfiles({"production", "local"})
public class ProfileEnvironmentTest {

    @Autowired
    private TestApplication.SampleProfile sampleProfile;

    @Test
    void testActiveProfiles() {
        assertArrayEquals(new String[]{"production", "local"}, sampleProfile.getProfiles());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleProfile implements EnvironmentAware {

            @Setter
            private Environment environment;

            public String[] getProfiles() {
                return environment.getActiveProfiles();
            }
        }
    }
}