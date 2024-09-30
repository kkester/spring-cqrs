package io.spring.cqrs.product_command.service;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductEventType;
import io.spring.cqrs.common.ProductRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.PublishedEvents;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void should_create_product(PublishedEvents events) {
        ZonedDateTime now = ZonedDateTime.now();
        NewProductRecord newProductRecord = new NewProductRecord("myProduct", "Long Description", "1qaz-2wsx");

        ProductRecord product = productService.createProduct(newProductRecord);

        assertThat(product.id()).isNotNull();
        assertThat(product).isEqualTo(new ProductRecord(product.id(), newProductRecord.name(), newProductRecord.description(), newProductRecord.sku()));

        var productEvents = events.ofType(ProductChangedEvent.class)
                .matching(event -> event.getProductId().equals(product.id()));
        assertThat(productEvents).hasSize(1);
        productEvents.forEach(event -> {
            assertThat(event.getEventType()).isEqualTo(ProductEventType.CREATED);
            assertThat(event.getPublicationDate()).isBetween(now, ZonedDateTime.now());
        });
    }

    @Test
    void should_update_product(PublishedEvents events) {
        ZonedDateTime now = ZonedDateTime.now();
        UUID productId = UUID.randomUUID();
        ProductRecord productRecord = new ProductRecord(null, "myProduct", "Long Description", "1qaz-2wsx");

        ProductRecord product = productService.updateProduct(productId, productRecord);

        assertThat(product.id()).isNotNull();
        assertThat(product).isEqualTo(new ProductRecord(product.id(), productRecord.name(), productRecord.description(), productRecord.sku()));

        var productEvents = events.ofType(ProductChangedEvent.class)
                .matching(event -> event.getProductId().equals(product.id()));
        assertThat(productEvents).hasSize(1);
        productEvents.forEach(event -> {
            assertThat(event.getEventType()).isEqualTo(ProductEventType.UPDATED);
            assertThat(event.getPublicationDate()).isBetween(now, ZonedDateTime.now());
        });
    }
}