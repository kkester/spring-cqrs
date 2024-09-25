package io.spring.cqrs.product_query.service;

import io.spring.cqrs.product_query.ProductRecord;
import io.spring.cqrs.product_query.RetrieveProducts;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Application
@RequiredArgsConstructor
public class RetrieveProductNotificationService implements RetrieveProducts, ProductNotification {

    private final QueryProducts queryProducts;
    private final StoreProduct storeProduct;

    @Override
    public List<ProductRecord> getProducts() {
        return queryProducts.getProducts();
    }

    @Override
    public void handle(ProductRecord productRecord) {
        storeProduct.store(productRecord);
    }
}
