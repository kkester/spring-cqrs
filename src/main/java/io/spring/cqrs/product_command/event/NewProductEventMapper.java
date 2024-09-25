package io.spring.cqrs.product_command.event;

import io.spring.cqrs.product_command.ProductCreatedEvent;
import io.spring.cqrs.product_command.SavedProduct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewProductEventMapper {
    ProductCreatedEvent recordToEvent(SavedProduct savedProduct);
}
