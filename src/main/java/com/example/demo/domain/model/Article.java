package com.example.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="articles")
@Data
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
}