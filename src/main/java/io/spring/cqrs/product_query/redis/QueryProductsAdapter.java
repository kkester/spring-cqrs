package io.spring.cqrs.product_query.redis;

import io.spring.cqrs.product_query.ProductRecord;
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
    public void store(ProductRecord productRecord) {
        Product product = productMapper.recordToProduct(productRecord);
        productRepository.save(product);
    }
}
