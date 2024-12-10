package io.spring.cqrs.product_query.service;

import io.spring.cqrs.common.ProductRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static io.spring.cqrs.product_query.ProductFactory.productRecord;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RetrieveProductNotificationServiceTest {

    @Mock
    QueryProducts queryProducts;

    @Mock
    StoreProduct storeProduct;

    @InjectMocks
    RetrieveProductNotificationService retrieveProductNotificationService;

    @Test
    void getProducts() {
        List<ProductRecord> products = List.of(productRecord());
        when(queryProducts.getProducts()).thenReturn(products);

        List<ProductRecord> results = retrieveProductNotificationService.getProducts();

        assertThat(results).isSameAs(products);
    }

    @Test
    void handleCreate() {
        ProductRecord productRecord = productRecord();

        retrieveProductNotificationService.handleCreate(productRecord);

        verify(storeProduct).save(productRecord);
    }
}