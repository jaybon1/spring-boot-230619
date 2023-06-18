package com.example.my.model.product.repository;

import com.example.my.domain.main.dto.ResMainQueryDslDTO;

import java.util.List;

public interface ProductRepositoryCustom {

    List<ResMainQueryDslDTO.Product> findAllByDynamic(Integer searchType, String searchValue);

}
