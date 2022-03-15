/**
 * dana.id.
 * Copyright (c) 2017‐2022 All Rights Reserved.
 */
package com.ahmadirfaanhibatullah.spring.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ApplicationProperties.java, v 0.1 2022‐03‐15 19.39 Ahmad Irfaan Hibatullah Exp $$
 */

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {

    private String name;

    private Integer version;

    private boolean productionMode;
}