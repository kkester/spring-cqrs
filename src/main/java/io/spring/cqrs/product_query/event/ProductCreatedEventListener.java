package io.spring.cqrs.product_query.event;

import io.spring.cqrs.product_command.ProductCreatedEvent;
import io.spring.cqrs.product_query.ProductRecord;
import io.spring.cqrs.product_query.service.ProductNotification;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@PrimaryAdapter
@RequiredArgsConstructor
public class ProductCreatedEventListener {

    private final ProductNotification productNotification;
    private final ProductEventMapper productEventMapper;

    @Async
    @EventListener
    public void onProductCreatedEvent(ProductCreatedEvent event) {
        ProductRecord productRecord = productEventMapper.eventToRecord(event);
        productNotification.handle(productRecord);
    }
}
