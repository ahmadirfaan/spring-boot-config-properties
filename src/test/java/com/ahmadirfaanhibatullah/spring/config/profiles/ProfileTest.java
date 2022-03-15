package com.ahmadirfaanhibatullah.spring.config.profiles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ProfileTest.java, v 0.1 2022‐03‐15 09.45 Ahmad Irfaan Hibatullah Exp $$
 */
@SpringBootTest(classes = ProfileTest.TestApplication.class)
@ActiveProfiles({"local"})
public class ProfileTest {

    @Autowired
    private TestApplication.SayHello sayHello;

    @Test
    void testProfile() {
        assertEquals("Hello Ahmad Irfaan from local", sayHello.say("Ahmad Irfaan"));
//        assertEquals("Hello Ahmad Irfaan from Production", sayHello.say("Ahmad Irfaan"));

    }

    @SpringBootApplication
    public static class TestApplication {

        public interface SayHello {
            String say(String name);
        }

        @Component
        @Profile({"local"})
        public static class SayHelloLocal implements SayHello {

            @Override
            public String say(String name) {
                return "Hello " + name + " from local";
            }
        }

        @Component
        @Profile({"production"})
        public static class SayHelloProduction implements SayHello {

            @Override
            public String say(String name) {
                return "Hello " + name + " from Production";
            }
        }
    }
}