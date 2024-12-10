package io.spring.cqrs.product_command.service;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductRecord;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

import java.util.List;
import java.util.UUID;

@SecondaryPort
public interface ProductPublisher {
    ProductChangedEvent productCreated(NewProductRecord newProductRecord);
    ProductChangedEvent productUpdated(UUID productId, ProductRecord savedProduct);
    void replayAllEvents(List<ProductChangedEvent> events);
}
