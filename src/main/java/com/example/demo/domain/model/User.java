package com.example.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private String userId;
    @Column(name="password")
    private String password;
    @Column(name="user_name")
    private String userName;
    @Column(name="gender")
    private boolean gender;
    @Column(name="role")
    private String role;
}
