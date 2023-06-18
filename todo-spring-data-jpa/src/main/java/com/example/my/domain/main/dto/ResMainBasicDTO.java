package com.example.my.domain.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.example.my.model.todo.entity.TodoEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResMainBasicDTO {

    List<Todo> todoList;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Todo {
        private Integer idx;
        private String content;
        private String doneYn;

        public static Todo fromEntity(TodoEntity todoEntity){
            return Todo.builder()
                    .idx(todoEntity.getIdx())
                    .content(todoEntity.getContent())
                    .doneYn(todoEntity.getDoneYn())
                    .build();
        }
    }

    public static List<Todo> fromEntity(List<TodoEntity> todoEntityList){
        return todoEntityList.stream().map(Todo::fromEntity).toList();
    }

    public static ResMainBasicDTO of(List<TodoEntity> todoEntityList){
        return ResMainBasicDTO.builder()
                .todoList(fromEntity(todoEntityList))
                .build();
    }
}
