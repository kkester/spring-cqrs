package io.spring.cqrs.product_command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {
    private Long id;
    private String name;
    private String description;
    private String sku;
}
