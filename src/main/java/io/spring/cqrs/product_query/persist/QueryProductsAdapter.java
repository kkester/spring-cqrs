package io.spring.cqrs.product_query.persist;

import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_query.service.QueryProducts;
import io.spring.cqrs.product_query.service.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SecondaryAdapter
@RequiredArgsConstructor
public class QueryProductsAdapter implements QueryProducts, StoreProduct {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductRecord> getProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::productToRecord)
                .toList();
    }

    @Override
    public void save(ProductRecord productRecord) {
        Product product = productMapper.recordToProduct(productRecord);
        productRepository.save(product);
    }

    @Override
    public void update(ProductRecord productRecord) {
        productRepository.findById(productRecord.id())
                .ifPresent(product -> {
                    productMapper.updateProductFromRecord(productRecord, product);
                    productRepository.save(product);
                });
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
