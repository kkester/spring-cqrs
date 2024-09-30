package io.spring.cqrs.product_query.web;

import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_query.RetrieveProducts;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PrimaryAdapter
@RestController
@RequiredArgsConstructor
public class ProductQueryController {

    private final RetrieveProducts retrieveProducts;

    @GetMapping("/api/products")
    public List<ProductRecord> getProducts() {
        return retrieveProducts.getProducts();
    }
}
