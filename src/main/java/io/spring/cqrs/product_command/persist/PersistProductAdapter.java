package io.spring.cqrs.product_command.persist;

import io.spring.cqrs.product_command.NewProductRecord;
import io.spring.cqrs.product_command.service.PersistProduct;
import io.spring.cqrs.product_command.SavedProduct;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Component;

@Component
@SecondaryAdapter
@RequiredArgsConstructor
public class PersistProductAdapter implements PersistProduct {

    private final ProductEntityRepository productEntityRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public SavedProduct save(NewProductRecord productRecord) {
        ProductEntity productEntity = productEntityMapper.newProductRecordToProductEntity(productRecord);
        ProductEntity savedProductEntity = productEntityRepository.save(productEntity);
        return productEntityMapper.entityToSavedProduct(savedProductEntity);
    }
}
