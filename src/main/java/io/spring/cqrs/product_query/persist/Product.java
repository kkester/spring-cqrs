package io.spring.cqrs.product_query.persist;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("product")
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private String sku;
}