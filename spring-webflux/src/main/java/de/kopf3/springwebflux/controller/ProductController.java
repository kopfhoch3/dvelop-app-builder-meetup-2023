package de.kopf3.springwebflux.controller;

import de.kopf3.springwebflux.controller.dto.ProductDto;
import de.kopf3.springwebflux.model.Product;
import de.kopf3.springwebflux.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/products/{id}")
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable Long id) {
        //log.info("Find product with id: {}", id);
        return productRepository.findById(id)
                                .map(ResponseEntity::ok)
                                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/products")
    public Flux<Product> getLatest() {
        //log.info("Find latest 20 products");
        return productRepository.findLatest();
    }

    @PostMapping("/products")
    public Mono<Product> saveProduct(@RequestBody Mono<ProductDto> product) {
        //log.info("Save product with name: {}", product);
        return product.flatMap(productDto -> this.productRepository.save(productDto.toProduct()));
    }
}
