package io.spring.cqrs.product_query.service;

import io.spring.cqrs.common.ProductRecord;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface ProductNotification {
    void handleCreate(ProductRecord productRecord);
    void handleUpdate(ProductRecord productRecord);
}
