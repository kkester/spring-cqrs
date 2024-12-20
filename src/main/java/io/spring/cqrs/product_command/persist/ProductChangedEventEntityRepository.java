package io.spring.cqrs.product_command.persist;

import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Adapter
public interface ProductChangedEventEntityRepository extends JpaRepository<ProductChangedEventEntity,Long> {
    List<ProductChangedEventEntity> findAllByOrderByPublicationDateAsc();
}
