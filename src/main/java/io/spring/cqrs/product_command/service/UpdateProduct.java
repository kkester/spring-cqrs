package io.spring.cqrs.product_command.service;

import io.spring.cqrs.common.ProductRecord;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

import java.util.UUID;

@PrimaryPort
public interface UpdateProduct {
    ProductRecord updateProduct(UUID productId, ProductRecord productRecord);
}
