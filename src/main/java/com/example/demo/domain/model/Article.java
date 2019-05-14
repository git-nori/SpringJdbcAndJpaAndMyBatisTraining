package com.example.demo.domain.model;

import lombok.Data;

@Data
public class Article{

    private Long id;
    private String userId;
    private String userName;
    private String title;
    private String content;
}