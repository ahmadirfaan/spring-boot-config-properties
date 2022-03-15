
package com.ahmadirfaanhibatullah.spring.config.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: ApplicationProperties.java, v 0.1 2022‐03‐15 19.39 Ahmad Irfaan Hibatullah Exp $$
 */

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {

    private Duration defaultTimeout;

    private Date expireDate;

    private String name;

    private Integer version;

    private boolean productionMode;

    private DatabaseProperties databaseProperties;

    private List<Role> defaultRoles;

    private Map<String, Role> roles;

    @Getter
    @Setter
    public static class DatabaseProperties {

        private String username;

        private String password;

        private String database;

        private String url;

        private List<String> whitelistTables;

        private Map<String, Integer> maxTablesSize;
     }

    @AllArgsConstructor
    @Data
    @ConstructorBinding
    public static class Role {

        private final String id;

        private final String name;
    }
}