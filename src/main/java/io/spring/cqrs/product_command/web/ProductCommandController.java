package io.spring.cqrs.product_command.web;

import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_command.service.NewProductRecord;
import io.spring.cqrs.product_command.service.CreateProduct;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@PrimaryAdapter
@RestController
@RequiredArgsConstructor
public class ProductCommandController {

    private final CreateProduct createProduct;

    @PostMapping("/api/products")
    public ProductRecord createProduct(@RequestBody NewProductRecord productRecord) {
        return createProduct.createProduct(productRecord);
    }

    @PutMapping("/api/products/{id}")
    public ProductRecord updateProduct(@PathVariable UUID id, @RequestBody ProductRecord productRecord) {
        return createProduct.updateProduct(id, productRecord);
    }

}
