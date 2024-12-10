package io.spring.cqrs.product_command.service;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_query.ClearProducts;
import io.spring.cqrs.product_query.ProductChangedEventHandler;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Application
@RequiredArgsConstructor
public class ProductService implements CreateProduct, UpdateProduct, RecreateProducts {

    private final ProductPublisher productNotification;
    private final PersistProductChangedEvent persistProductChangedEvent;
    private final ProductRecordMapper productRecordMapper;
    private final ClearProducts clearProducts;
    private final ProductChangedEventHandler productChangedEventHandler;

    @Override
    public ProductRecord createProduct(NewProductRecord newProductRecord) {
        ProductChangedEvent productChangedEvent = productNotification.productCreated(newProductRecord);
        persistProductChangedEvent.save(productChangedEvent);
        return productRecordMapper.eventToRecord(productChangedEvent);
    }

    @Override
    public ProductRecord updateProduct(UUID productId, ProductRecord productRecord) {
        ProductChangedEvent productChangedEvent = productNotification.productUpdated(productId, productRecord);
        persistProductChangedEvent.save(productChangedEvent);
        return productRecordMapper.eventToRecord(productChangedEvent);
    }

    @Override
    public void recreateProducts() {
        clearProducts.clearAllProducts();
        List<ProductChangedEvent> events = persistProductChangedEvent.getAllEvents();
        events.forEach(productChangedEventHandler::handleEvent);
    }
}
