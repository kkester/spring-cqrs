package io.spring.cqrs.product_query.event;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductEventMapper {
    @Mapping(source = "productId", target = "id")
    ProductRecord eventToRecord(ProductChangedEvent productChangedEvent);
}
