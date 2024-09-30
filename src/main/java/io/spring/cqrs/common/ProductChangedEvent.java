package io.spring.cqrs.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductChangedEvent {
    private UUID productId;
    private String name;
    private String description;
    private ProductEventType eventType;
    private String sku;
    private ZonedDateTime publicationDate;
}
