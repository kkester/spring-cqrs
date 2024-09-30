package io.spring.cqrs.product_query.event;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.common.ProductEventType;
import io.spring.cqrs.product_query.service.ProductNotification;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@PrimaryAdapter
@RequiredArgsConstructor
public class ProductChangedEventListener {

    private final ProductNotification productNotification;
    private final ProductEventMapper productEventMapper;

    @Async
    @EventListener
    public void onProductCreatedEvent(ProductChangedEvent event) {
        ProductRecord productRecord = productEventMapper.eventToRecord(event);
        ProductEventType productEventType = event.getEventType();
        switch (productEventType) {
            case CREATED -> productNotification.handleCreate(productRecord);
            case UPDATED -> productNotification.handleUpdate(productRecord);
        }
    }
}
