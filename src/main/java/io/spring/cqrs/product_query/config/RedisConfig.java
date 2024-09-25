package io.spring.cqrs.product_query.config;

import io.spring.cqrs.product_query.ProductRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, ProductRecord> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, ProductRecord> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(ProductRecord.class));
        return template;
    }

}
