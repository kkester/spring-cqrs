package io.spring.cqrs.product_query;

import io.spring.cqrs.common.ProductChangedEvent;

public interface ProductChangedEventHandler {
    void handleEvent(ProductChangedEvent productChangedEvent);
}
