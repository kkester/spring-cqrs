package io.spring.cqrs.product_query.service;

import io.spring.cqrs.product_query.ProductRecord;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface StoreProduct {
    void store(ProductRecord productRecord);
}
