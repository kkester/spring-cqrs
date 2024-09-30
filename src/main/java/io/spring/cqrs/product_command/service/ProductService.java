package io.spring.cqrs.product_command.service;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductRecord;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Application
@RequiredArgsConstructor
public class ProductService implements CreateProduct {

    private final ProductPublisher productNotification;
    private final PersistProductChangedEvent persistProductChangedEvent;
    private final ProductRecordMapper productRecordMapper;

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
}
