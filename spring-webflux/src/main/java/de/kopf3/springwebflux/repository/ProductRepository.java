package de.kopf3.springwebflux.repository;

import de.kopf3.springwebflux.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

    @Query("SELECT * FROM product ORDER BY instant DESC LIMIT 1000")
    Flux<Product> findLatest();

}
