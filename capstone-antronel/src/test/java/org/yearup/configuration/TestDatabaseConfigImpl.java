package org.yearup.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

public class TestDatabaseConfigImpl extends TestDatabaseConfig {
    public TestDatabaseConfigImpl(String serverUrl, String username, String password, String testDb) {
        super(serverUrl, username, password, testDb);
    }

    @Configuration
@EnableConfigurationProperties  // Add this if missing
public class TestDatabaseConfig {
    // ...
}
}
