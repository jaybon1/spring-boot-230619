package com.example.my.domain.main.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResMainQueryDslDTO {

    List<Product> productList;

    @Data
    @Builder
    @NoArgsConstructor
    public static class Product {
        private Integer id;
        private String name;
        private String discountYn;
        private Integer price;
        private Integer discountPrice;
        private String kind;
        private String maker;

        @QueryProjection
        public Product(Integer id, String name, String discountYn, Integer price, Integer discountPrice, String kind, String maker) {
            this.id = id;
            this.name = name;
            this.discountYn = discountYn;
            this.price = price;
            this.discountPrice = discountPrice;
            this.kind = kind;
            this.maker = maker;
        }
    }

    public static ResMainQueryDslDTO of(List<Product> productList) {
        return ResMainQueryDslDTO.builder()
                .productList(productList)
                .build();
    }
}
