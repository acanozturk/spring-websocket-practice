package com.practice.websocketpractice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.practice.websocketpractice.repository")
@EnableMongoAuditing
public class MongoConfig {
}
