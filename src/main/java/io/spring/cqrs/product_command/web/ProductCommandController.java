package io.spring.cqrs.product_command.web;

import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_command.service.CreateProduct;
import io.spring.cqrs.product_command.service.NewProductRecord;
import io.spring.cqrs.product_command.service.RecreateProducts;
import io.spring.cqrs.product_command.service.UpdateProduct;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@PrimaryAdapter
@RestController
@RequiredArgsConstructor
public class ProductCommandController {

    private final CreateProduct createProduct;
    private final UpdateProduct updateProduct;
    private final RecreateProducts recreateProducts;

    @PostMapping("/api/products")
    public ProductRecord createProduct(@RequestBody NewProductRecord productRecord) {
        return createProduct.createProduct(productRecord);
    }

    @PutMapping("/api/products/{id}")
    public ProductRecord updateProduct(@PathVariable UUID id, @RequestBody ProductRecord productRecord) {
        return updateProduct.updateProduct(id, productRecord);
    }

    @PutMapping("/api/products")
    public ResponseEntity<Void> recreateProducts() {
        recreateProducts.recreateProducts();
        return ResponseEntity.noContent().build();
    }
}
