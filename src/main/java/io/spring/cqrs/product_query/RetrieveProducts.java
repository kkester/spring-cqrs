package io.spring.cqrs.product_query;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import java.util.List;

@PrimaryPort
public interface RetrieveProducts {
    List<ProductRecord> getProducts();
}
