package io.spring.cqrs.product_command.persist;

import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
public interface ProductEntityRepository extends JpaRepository<ProductEntity,Long> {
}
