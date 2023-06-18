package com.example.my.model.product.repository;

import com.example.my.model.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>, ProductRepositoryCustom {
}
