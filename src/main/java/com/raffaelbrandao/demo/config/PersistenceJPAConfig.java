package com.raffaelbrandao.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.raffaelbrandao.demo.repositories")
public class PersistenceJPAConfig {
}
