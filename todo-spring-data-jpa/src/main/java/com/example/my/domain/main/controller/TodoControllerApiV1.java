package com.example.my.domain.main.controller;

import com.example.my.common.dto.ResponseDTO;
import com.example.my.domain.main.dto.ResMainBasicDTO;
import com.example.my.domain.main.service.MainServiceApiV1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/main")
public class TodoControllerApiV1 {

    private final MainServiceApiV1 todoServiceApiV1;

    @GetMapping
    public HttpEntity<ResponseDTO<ResMainBasicDTO>> getTodoList(){
        return todoServiceApiV1.getTodoList();
    }

}
