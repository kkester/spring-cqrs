package io.spring.cqrs.product_command.service;

import io.spring.cqrs.product_command.NewProductRecord;
import io.spring.cqrs.product_command.SavedProduct;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface PersistProduct {
    SavedProduct save(NewProductRecord productRecord);
}
