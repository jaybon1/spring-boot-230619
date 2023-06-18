package com.example.my.domain.main.service;

import com.example.my.common.dto.ResponseDTO;
import com.example.my.domain.main.dto.ResMainQueryDslDTO;
import com.example.my.model.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainServiceApiV1 {

    private final ProductRepository productRepository;

    public HttpEntity<ResponseDTO<ResMainQueryDslDTO>> getProductList(Integer searchType, String searchValue) {
        return new ResponseEntity<>(
                ResponseDTO.<ResMainQueryDslDTO>builder()
                        .code(0)
                        .message("상품 리스트 조회에 성공했습니다.")
                        .data(ResMainQueryDslDTO.of(productRepository.findAllByDynamic(searchType, searchValue)))
                        .build(),
                HttpStatus.OK
        );
    }
}
