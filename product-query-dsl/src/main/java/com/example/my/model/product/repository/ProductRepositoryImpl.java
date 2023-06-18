package com.example.my.model.product.repository;


import com.example.my.domain.main.dto.QResMainQueryDslDTO_Product;
import com.example.my.domain.main.dto.ResMainQueryDslDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.my.model.product.entity.QProductEntity.productEntity;
import static com.example.my.model.product.entity.QProductKindEntity.productKindEntity;
import static com.example.my.model.product.entity.QProductMakerEntity.productMakerEntity;


// ItemCustomRepository 에서 생성한 인터페이스를 여기서 구현
@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    // 참고 QueryDsl은 from절에 서브쿼리가 불가능하다.
    // 배민에서는 조건을 미리 걸어 쿼리를 하여 리스트를 가져오고
    // 해당 리스트를 다음 쿼리의 where 서브쿼리의 조건으로 넣어서 해결했다고 함.
    @Override
    public List<ResMainQueryDslDTO.Product> findAllByDynamic(Integer searchType, String searchValue) {
        JPAQuery<ResMainQueryDslDTO.Product> query = jpaQueryFactory
                .select(new QResMainQueryDslDTO_Product(
                        productEntity.idx,
                        productEntity.name,
                        productEntity.discountYn,
                        productEntity.price,
                        productEntity.discountPrice,
                        productKindEntity.name,
                        productMakerEntity.name
                ))
                .from(productEntity)
                .where(customSearch(searchType, searchValue)) // 동적 조건을 위한 함수호출
                .orderBy(productEntity.idx.desc()); // 역정렬

        return query.fetch();
    }


    // searchType에 따라 동적으로 쿼리를 변경시킨다.
    private BooleanExpression customSearch(Integer searchType, String searchValue){

        BooleanExpression n = productEntity.name.isNotEmpty();

        // 주의 productKindEntity처럼 기준테이블이나 조인에 쓰이지 않은 테이블은 조건에 넣으면 안된다.
        if (searchType == 1){
            n = n.and(productEntity.name.contains(searchValue));
        } else if (searchType == 2){
            n = n.and(productMakerEntity.name.contains(searchValue));
        }
        return n;
    }
}


