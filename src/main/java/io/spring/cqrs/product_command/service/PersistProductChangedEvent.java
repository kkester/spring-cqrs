package io.spring.cqrs.product_command.service;

import io.spring.cqrs.common.ProductChangedEvent;

public interface PersistProductChangedEvent {
    void save(ProductChangedEvent productChangedEvent);
}
