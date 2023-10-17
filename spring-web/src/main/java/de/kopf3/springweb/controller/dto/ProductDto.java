package de.kopf3.springweb.controller.dto;

import de.kopf3.springweb.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .instant(Instant.now())
                .build();
    }
}
