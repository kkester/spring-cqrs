package io.spring.cqrs.product_command.web;

import io.spring.cqrs.product_command.NewProductRecord;
import io.spring.cqrs.product_command.CreateProduct;
import io.spring.cqrs.product_command.SavedProduct;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@PrimaryAdapter
@RestController
@RequiredArgsConstructor
public class ProductCommandController {

    private final CreateProduct createProduct;

    @PostMapping("/api/products")
    public SavedProduct createProduct(@RequestBody NewProductRecord productRecord) {
        return createProduct.createProduct(productRecord);
    }

}
