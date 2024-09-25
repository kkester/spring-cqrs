package io.spring.cqrs.product_query;


public record ProductRecord(Long id,
                            String name,
                            String description,
                            String sku) {
}
