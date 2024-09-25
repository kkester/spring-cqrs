package io.spring.cqrs.product_command.service;

import io.spring.cqrs.product_command.CreateProduct;
import io.spring.cqrs.product_command.NewProductRecord;
import io.spring.cqrs.product_command.SavedProduct;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

@Service
@Application
@RequiredArgsConstructor
public class ProductService implements CreateProduct {

    private final PersistProduct persistProduct;
    private final ProductPublisher productNotification;

    @Override
    public SavedProduct createProduct(NewProductRecord productRecord) {
        SavedProduct savedProduct = persistProduct.save(productRecord);
        productNotification.productCreated(savedProduct);
        return savedProduct;
    }
}
