package com.maintainhub.cmms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main application class for the MaintainHub CMMS system.
 * 
 * <p>This class serves as the entry point for the Spring Boot application.
 * It configures:</p>
 * 
 * <ul>
 *   <li>Component scanning for all packages</li>
 *   <li>JPA repository scanning</li>
 *   <li>Entity scanning</li>
 * </ul>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 */
@SpringBootApplication
@EntityScan("com.maintainhub.cmms.entity")
@EnableJpaRepositories("com.maintainhub.cmms.repository")
public class CmmsApplication {

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CmmsApplication.class, args);
    }
} 