package com.ahmadirfaanhibatullah.spring.config.springbootmessagesource;

import lombok.Setter;
import org.apache.logging.log4j.message.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: SpringBootMessageSourceTest.java, v 0.1 2022‐03‐13 20.34 Ahmad Irfaan Hibatullah Exp $$
 */

@SpringBootTest(classes = SpringBootMessageSourceTest.TestApplication.class)
public class SpringBootMessageSourceTest {

    @Autowired
    private TestApplication.SampleSource sampleSource;

    @Test
    void testHelloIrfaan() {
        assertEquals("Hello Ahmad Irfaan", sampleSource.helloIrfaan(Locale.ENGLISH));
        assertEquals("Halo Ahmad Irfaan", sampleSource.helloIrfaan(new Locale("in", "ID")));

    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleSource implements MessageSourceAware {

            @Setter
            private MessageSource messageSource;

            private String helloIrfaan(Locale locale) {
                return messageSource.getMessage("hello", new Object[]{"Ahmad Irfaan"}, locale);
            }

        }
    }
}