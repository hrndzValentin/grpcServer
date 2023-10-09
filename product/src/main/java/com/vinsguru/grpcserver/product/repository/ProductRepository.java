package com.vinsguru.grpcserver.product.repository;

import com.vinsguru.grpcserver.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,Integer> {
}
