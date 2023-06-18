package com.example.my.domain.main.service;

import com.example.my.common.dto.ResponseDTO;
import com.example.my.domain.main.dto.ResMainBasicDTO;
import com.example.my.model.todo.repository.TodoRepository;

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

    private final TodoRepository todoRepository;

    public HttpEntity<ResponseDTO<ResMainBasicDTO>> getTodoList(){
        return new ResponseEntity<>(
                ResponseDTO.<ResMainBasicDTO>builder()
                        .code(0)
                        .message("할 일 리스트 조회에 성공했습니다.")
                        .data(ResMainBasicDTO.of(todoRepository.findByDeleteDateIsNull()))
                        .build(),
                HttpStatus.OK
        );
    }
}
