package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class ToDo {

    @Id @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    private String title;

    private String content;

    protected ToDo(){}

    public ToDo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void changeTitle(String title) {this.title = title;}

    public void changeContent(String content) {this.content = content;}
}
