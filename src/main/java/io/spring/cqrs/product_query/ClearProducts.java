package io.spring.cqrs.product_query;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface ClearProducts {
    void clearAllProducts();
}
