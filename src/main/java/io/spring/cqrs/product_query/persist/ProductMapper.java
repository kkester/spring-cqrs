package io.spring.cqrs.product_query.persist;

import io.spring.cqrs.common.ProductRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductRecord productToRecord(Product product);
    Product recordToProduct(ProductRecord productRecord);
    void updateProductFromRecord(ProductRecord productRecord, @MappingTarget Product product);
}
