package com.maintainhub.cmms.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> 
            String.format("jdbc:postgresql://%s:%s/%s",
                System.getenv().getOrDefault("DB_HOST", "localhost"),
                System.getenv().getOrDefault("DB_PORT", "5432"),
                System.getenv().getOrDefault("DB_NAME", "cmms_test_db")));
        registry.add("spring.datasource.username", () -> 
            System.getenv().getOrDefault("DB_USER", "cmms_user"));
        registry.add("spring.datasource.password", () -> 
            System.getenv().getOrDefault("DB_PASSWORD", "cmms_password"));
    }

    @Test
    public void testDatabaseConnection() {
        assertNotNull(jdbcTemplate, "JdbcTemplate should not be null");
        
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            assertEquals(1, result, "Database query should return 1");
        } catch (Exception e) {
            fail("Database connection test failed: " + e.getMessage() +
                "\nCheck if database is running and credentials are correct." +
                "\nDB_HOST: " + System.getenv().getOrDefault("DB_HOST", "localhost") +
                "\nDB_PORT: " + System.getenv().getOrDefault("DB_PORT", "5432") +
                "\nDB_NAME: " + System.getenv().getOrDefault("DB_NAME", "cmms_test_db") +
                "\nDB_USER: " + System.getenv().getOrDefault("DB_USER", "cmms_user"));
        }
    }
} 