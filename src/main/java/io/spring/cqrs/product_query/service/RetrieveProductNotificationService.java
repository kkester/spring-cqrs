package io.spring.cqrs.product_query.service;

import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_query.ClearProducts;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Application
@RequiredArgsConstructor
public class RetrieveProductNotificationService implements RetrieveProducts, ProductNotification, ClearProducts {

    private final QueryProducts queryProducts;
    private final StoreProduct storeProduct;

    @Override
    public List<ProductRecord> getProducts() {
        return queryProducts.getProducts();
    }

    @Override
    public void handleCreate(ProductRecord productRecord) {
        storeProduct.save(productRecord);
    }

    @Override
    public void handleUpdate(ProductRecord productRecord) {
        storeProduct.update(productRecord);
    }

    @Override
    public void clearAllProducts() {
        storeProduct.deleteAll();
    }
}
