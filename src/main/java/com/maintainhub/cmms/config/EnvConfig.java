package com.maintainhub.cmms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import java.io.File;

@Configuration
@PropertySource(value = "file:${user.dir}/.env", ignoreResourceNotFound = true)
public class EnvConfig {
    // The @PropertySource annotation will load the .env file from the project root
    // ignoreResourceNotFound = true ensures the application can start even if .env is missing
} 