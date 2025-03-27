package com.example.demo.dto;

import lombok.Getter;

@Getter
public class ToDoDto {
    private String title;
    private String content;

    protected ToDoDto() {};

    public ToDoDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
