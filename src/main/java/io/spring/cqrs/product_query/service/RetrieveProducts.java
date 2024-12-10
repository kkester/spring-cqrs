package io.spring.cqrs.product_query.service;

import io.spring.cqrs.common.ProductRecord;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

import java.util.List;

@PrimaryPort
public interface RetrieveProducts {
    List<ProductRecord> getProducts();
}
