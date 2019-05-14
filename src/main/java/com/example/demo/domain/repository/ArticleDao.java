package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.domain.model.Article;

public interface ArticleDao {

    public int count() throws DataAccessException;

    public int insertOne(Article article) throws DataAccessException;

    public Article selectOne(Long id) throws DataAccessException;

    public List<Article> selectMany() throws DataAccessException;

    public int updateOne(Article article) throws DataAccessException;

    public int deleteOne(Long id) throws DataAccessException;

    public Article selectDistinctUserIdByUserId(String userId) throws DataAccessException;

    public Article selectOneJoinMUserByUserId(Long id) throws DataAccessException;
}
