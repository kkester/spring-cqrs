package io.spring.cqrs.product_command;

public record SavedProduct(
        Long id,
        String name,
        String description,
        String sku) {
}
