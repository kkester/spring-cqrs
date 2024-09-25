package io.spring.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories(basePackages = "io.spring.cqrs.product_command")
@EnableRedisRepositories(basePackages = "io.spring.cqrs.product_query")
public class CqrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsApplication.class, args);
	}

}
