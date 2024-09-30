package io.spring.cqrs.product_command.persist;

import io.spring.cqrs.common.ProductEventType;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "event_publication")
public class ProductChangedEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID productId;
    private ProductEventType eventType;
    private String serializedEvent;
    private ZonedDateTime publicationDate;
}
