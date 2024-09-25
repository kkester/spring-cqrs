package io.spring.cqrs.product_query.service;

import io.spring.cqrs.product_query.ProductRecord;
import org.jmolecules.architecture.hexagonal.PrimaryPort;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

import java.util.List;

@SecondaryPort
public interface QueryProducts {
    List<ProductRecord> getProducts();
}
