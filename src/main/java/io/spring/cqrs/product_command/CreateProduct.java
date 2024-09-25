package io.spring.cqrs.product_command;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface CreateProduct {
    SavedProduct createProduct(NewProductRecord productRecord);
}
