package io.spring.cqrs.product_query;

import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_command.service.NewProductRecord;

import java.util.UUID;

public class ProductFactory {
    public static ProductRecord productRecord() {
        return new ProductRecord(UUID.randomUUID(), "butter", "creamy", "1qaz-2wsx");
    }

    public static NewProductRecord newProductRecord() {
        return new NewProductRecord("butter", "creamy", "1qaz-2wsx");
    }
}
