package io.spring.cqrs.product_command.event;

import io.spring.cqrs.product_command.service.ProductPublisher;
import io.spring.cqrs.product_command.SavedProduct;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@SecondaryAdapter
@RequiredArgsConstructor
public class ProductPublisherAdapter implements ProductPublisher {

    private final ApplicationEventPublisher eventPublisher;
    private final NewProductEventMapper newProductEventMapper;

    @Override
    public void productCreated(SavedProduct savedProduct) {
        eventPublisher.publishEvent(newProductEventMapper.recordToEvent(savedProduct));
    }
}
