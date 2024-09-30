package io.spring.cqrs.product_command.event;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductEventType;
import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_command.service.NewProductRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.ZonedDateTime;
import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductChangedEventMapper {
    @Mapping(target = "eventType", source = "eventType")
    @Mapping(target = "publicationDate", source = "publicationDate")
    @Mapping(target = "productId", source = "productId")
    ProductChangedEvent recordToEvent(ProductRecord productRecord, UUID productId, ProductEventType eventType,  ZonedDateTime publicationDate);

    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "eventType", source = "eventType")
    @Mapping(target = "publicationDate", source = "publicationDate")
    ProductChangedEvent recordToEvent(NewProductRecord newProductRecord, UUID productId, ProductEventType eventType, ZonedDateTime publicationDate);
}
