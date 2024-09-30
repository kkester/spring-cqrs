package io.spring.cqrs.product_command.event;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.common.ProductEventType;
import io.spring.cqrs.product_command.service.NewProductRecord;
import io.spring.cqrs.product_command.service.ProductPublisher;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component
@SecondaryAdapter
@RequiredArgsConstructor
public class ProductPublisherAdapter implements ProductPublisher {

    private final ApplicationEventPublisher eventPublisher;
    private final ProductChangedEventMapper productEventMapper;

    @Override
    public ProductChangedEvent productCreated(NewProductRecord newProductRecord) {
        ProductChangedEvent productChangedEvent = productEventMapper.recordToEvent(newProductRecord, UUID.randomUUID(), ProductEventType.CREATED, ZonedDateTime.now());
        eventPublisher.publishEvent(productChangedEvent);
        return productChangedEvent;
    }

    @Override
    public ProductChangedEvent productUpdated(UUID productId, ProductRecord productRecord) {
        ProductChangedEvent productChangedEvent = productEventMapper.recordToEvent(productRecord, productId, ProductEventType.UPDATED, ZonedDateTime.now());
        eventPublisher.publishEvent(productChangedEvent);
        return productChangedEvent;
    }
}
