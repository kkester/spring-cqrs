package io.spring.cqrs.product_query.persist;

import io.spring.cqrs.product_query.ProductRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductRecord productToRecord(Product product);
    Product recordToProduct(ProductRecord productRecord);
}
