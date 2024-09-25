package io.spring.cqrs.product_command.persist;

import io.spring.cqrs.product_command.NewProductRecord;
import io.spring.cqrs.product_command.SavedProduct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductEntityMapper {
    ProductEntity newProductRecordToProductEntity(NewProductRecord productRecord);
    SavedProduct entityToSavedProduct(ProductEntity savedProductEntity);
}
