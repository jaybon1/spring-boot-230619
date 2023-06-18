package com.example.my.model.product.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT")
@EqualsAndHashCode(of = "idx", callSuper = false)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Integer idx;

    @Column(name = "name")
    private String name;

    @Column(name = "discount_yn")
    private String discountYn;

    @Column(name = "price")
    private Integer price;

    @Column(name = "discount_price")
    private Integer discountPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_kind_idx", referencedColumnName = "idx")
    private ProductKindEntity productKindEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_maker_idx", referencedColumnName = "idx")
    private ProductMakerEntity productMakerEntity;

    @Column(name = "stock")
    private Integer stock;

}