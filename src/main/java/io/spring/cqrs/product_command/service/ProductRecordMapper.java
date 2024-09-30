package io.spring.cqrs.product_command.service;

import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.common.ProductRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductRecordMapper {
    @Mapping(target = "id", source = "productId")
    ProductRecord eventToRecord(ProductChangedEvent productChangedEvent);
}
