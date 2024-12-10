package io.spring.cqrs.product_command.service;

import io.spring.cqrs.common.ProductChangedEvent;

import java.util.List;

public interface PersistProductChangedEvent {
    void save(ProductChangedEvent productChangedEvent);
    List<ProductChangedEvent> getAllEvents();
}
