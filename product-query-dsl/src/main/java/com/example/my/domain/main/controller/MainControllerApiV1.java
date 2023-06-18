package com.example.my.domain.main.controller;

import com.example.my.common.dto.ResponseDTO;
import com.example.my.domain.main.dto.ResMainQueryDslDTO;
import com.example.my.domain.main.service.MainServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/main")
public class MainControllerApiV1 {

    private final MainServiceApiV1 mainServiceApiV1;

    @GetMapping
    public HttpEntity<ResponseDTO<ResMainQueryDslDTO>> findAllByDynamic(
            @RequestParam(value = "searchType", defaultValue = "0") Integer searchType,
            @RequestParam(value = "searchValue", defaultValue = "") String searchValue
    ){
        return mainServiceApiV1.getProductList(searchType, searchValue);
    }


}
