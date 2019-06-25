package com.ofaul.system.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.ofaul.business")
@EnableJpaRepositories(basePackages = "com.ofaul.business.repository")
public class ApplicationConfiguration {
}
