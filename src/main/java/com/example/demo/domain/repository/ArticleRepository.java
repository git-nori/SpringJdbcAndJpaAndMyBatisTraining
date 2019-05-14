package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a ORDER BY a.id DESC")
    List<Article> findAllOrderByIdDesc();

    @Query("SELECT a FROM Article a WHERE a.title = :title")
    Article findByTitle(@Param("title") String title);
}
