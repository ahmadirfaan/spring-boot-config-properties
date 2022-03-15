package com.ahmadirfaanhibatullah.spring.config.runner;

import com.ahmadirfaanhibatullah.spring.config.properties.ApplicationProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ApplicationPropertiesRunner.java, v 0.1 2022‐03‐15 21.37 Ahmad Irfaan Hibatullah Exp $$
 */
@Component
@AllArgsConstructor
@Slf4j
public class ApplicationPropertiesRunner implements ApplicationRunner {


    private ApplicationProperties applicationProperties;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(applicationProperties.getName());
        log.info(String.valueOf(applicationProperties.getVersion()));
        log.info(String.valueOf(applicationProperties.isProductionMode()));
    }
}