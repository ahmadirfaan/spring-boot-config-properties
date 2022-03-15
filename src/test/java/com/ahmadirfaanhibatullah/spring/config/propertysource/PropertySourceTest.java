package com.ahmadirfaanhibatullah.spring.config.propertysource;

import com.ahmadirfaanhibatullah.spring.config.value.ValueTest;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: PropertySourceTest.java, v 0.1 2022‐03‐15 09.31 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest(classes = PropertySourceTest.TestApplication.class)
public class PropertySourceTest {

    @Autowired
    private TestApplication.SampleProperties sampleProperties;


    @Test
    void testPropertySource() {
        Assertions.assertEquals("Sample Project", sampleProperties.getName());
        Assertions.assertEquals(1, sampleProperties.getVersion());
    }




    @SpringBootApplication
    @PropertySources({
            @PropertySource("classpath:/sample.properties")
    })
    public static class TestApplication {

        @Component
        @Getter
        public static class SampleProperties {

            @Value("${sample.name}")
            private String name;

            @Value("${sample.version}")
            private Integer version;
        }
    }

}