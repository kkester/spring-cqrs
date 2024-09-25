package io.spring.cqrs.product_query.service;

import io.spring.cqrs.product_query.ProductRecord;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface ProductNotification {
    void handle(ProductRecord productRecord);
}
