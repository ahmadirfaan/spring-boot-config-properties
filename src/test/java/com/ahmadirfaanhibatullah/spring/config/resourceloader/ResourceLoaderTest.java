package com.ahmadirfaanhibatullah.spring.config.resourceloader;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ResourceLoaderTest.java, v 0.1 2022‐03‐13 20.04 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest(classes = ResourceLoaderTest.TestApplication.class)
public class ResourceLoaderTest {

    @Autowired
    private TestApplication.SampleResource sampleResource;

    @Test
    void testResourceLoader() throws IOException {
        String text = sampleResource.getText();
        System.out.println(text);
        assertTrue(text.contains("Irfaan"));
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleResource implements ResourceLoaderAware {

            @Setter
            private ResourceLoader resourceLoader;

            public String getText() throws IOException {
                Resource resource = resourceLoader.getResource("classpath:/text/resource.txt");
                try(InputStream inputStream = resource.getInputStream()) {
                    return new String(StreamUtils.copyToByteArray(inputStream));
                }
            }
        }
    }



}