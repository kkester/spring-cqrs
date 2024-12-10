package io.spring.cqrs.product_query.service;

import io.spring.cqrs.common.ProductRecord;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface StoreProduct {
    void save(ProductRecord productRecord);
    void update(ProductRecord productRecord);
    void deleteAll();
}
