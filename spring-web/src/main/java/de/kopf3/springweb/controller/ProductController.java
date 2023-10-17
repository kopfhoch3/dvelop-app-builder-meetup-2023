package de.kopf3.springweb.controller;

import de.kopf3.springweb.controller.dto.ProductDto;
import de.kopf3.springweb.model.Product;
import de.kopf3.springweb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        log.info("Find product with id: {}", id);
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/products")
    public List<Product> getLatest() {
        log.info("Find latest 20 products");
        return productRepository.findAll(PageRequest.of(0, 10_000,
                                                        Sort.by("instant").descending())).toList();
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody ProductDto product) {
        log.info("Save product witn name: {}", product);
        return productRepository.save(product.toProduct());
    }
}
