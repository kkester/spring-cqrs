package io.spring.cqrs.common;


import java.util.UUID;

public record ProductRecord(UUID id,
                            String name,
                            String description,
                            String sku) {
}
