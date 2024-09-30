package io.spring.cqrs.product_command.persist;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.cqrs.common.ProductChangedEvent;
import io.spring.cqrs.product_command.service.PersistProductChangedEvent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@SecondaryAdapter
@RequiredArgsConstructor
public class PersistProductAdapter implements PersistProductChangedEvent {

    private final ProductChangedEventEntityRepository productChangedEventEntityRepository;
    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public void save(ProductChangedEvent productChangedEvent) {
        ProductChangedEventEntity productChangedEventEntity = ProductChangedEventEntity.builder()
                .productId(productChangedEvent.getProductId())
                .eventType(productChangedEvent.getEventType())
                .serializedEvent(objectMapper.writeValueAsString(productChangedEvent))
                .publicationDate(ZonedDateTime.now())
                .build();
        productChangedEventEntityRepository.save(productChangedEventEntity);
    }
}
