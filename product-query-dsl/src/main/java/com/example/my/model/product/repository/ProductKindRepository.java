package com.example.my.model.product.repository;

import com.example.my.model.product.entity.ProductKindEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductKindRepository extends JpaRepository<ProductKindEntity, Integer> {
}
