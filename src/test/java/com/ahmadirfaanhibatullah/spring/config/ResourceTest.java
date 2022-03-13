package com.ahmadirfaanhibatullah.spring.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ResourceTest.java, v 0.1 2022‐03‐13 19.54 Ahmad Irfaan Hibatullah Exp $$
 */
public class ResourceTest {

    @Test
    void testResource() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("/text/sample.txt");

        assertNotNull(classPathResource);

        assertTrue(classPathResource.exists());
        assertNotNull(classPathResource.getFile());
    }
}