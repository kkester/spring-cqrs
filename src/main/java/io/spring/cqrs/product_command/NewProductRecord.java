package io.spring.cqrs.product_command;

public record NewProductRecord(
        String name,
        String description,
        String sku) {
}
