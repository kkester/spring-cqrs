package io.spring.cqrs.product_query.event;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductEventType;
import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_query.ProductChangedEventHandler;
import io.spring.cqrs.product_query.service.ProductNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@PrimaryAdapter
@RequiredArgsConstructor
@Slf4j
public class ProductChangedEventProcessor implements ProductChangedEventHandler {

    private final ProductNotification productNotification;
    private final ProductEventMapper productEventMapper;

    @Override
    public void handleEvent(ProductChangedEvent event) {
        log.info("Handling product changed event: {}", event);
        ProductRecord productRecord = productEventMapper.eventToRecord(event);
        ProductEventType productEventType = event.getEventType();
        switch (productEventType) {
            case CREATED -> productNotification.handleCreate(productRecord);
            case UPDATED -> productNotification.handleUpdate(productRecord);
        }
    }
}
