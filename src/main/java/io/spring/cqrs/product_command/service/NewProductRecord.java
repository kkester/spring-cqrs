package io.spring.cqrs.product_command.service;

public record NewProductRecord(
        String name,
        String description,
        String sku) {
}
