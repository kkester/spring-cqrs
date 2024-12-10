package io.spring.cqrs.product_query.event;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.product_query.ProductChangedEventHandler;
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
public class ProductChangedEventListener {

    private final ProductChangedEventHandler productChangedEventHandler;

    @EventListener
    @Async
    public void onProductChangedEvent(ProductChangedEvent event) {
        productChangedEventHandler.handleEvent(event);
    }

}
