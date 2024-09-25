package io.spring.cqrs.product_query.event;

import io.spring.cqrs.product_command.ProductCreatedEvent;
import io.spring.cqrs.product_query.ProductRecord;
import io.spring.cqrs.product_query.redis.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductEventMapper {
    ProductRecord eventToRecord(ProductCreatedEvent productCreatedEvent);
}
