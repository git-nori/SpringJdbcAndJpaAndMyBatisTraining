package com.example.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.model.Article;
import com.example.demo.domain.repository.ArticleDao;

@Service
@Transactional
public class ArticleService {

    @Autowired
    ArticleDao dao;

    public boolean insert(Article article) {

        int rowNumber = dao.insertOne(article);

        boolean result = false;

        if (rowNumber > 0) {
            result = true;
        }

        return result;
    }

    public int count() {
        return dao.count();
    }

    public List<Article> selectMany(){
        return dao.selectMany();
    }

    public Article selectOne(Long id) {
        return dao.selectOne(id);
    }

    public boolean updateOne(Article article) {

        int rowNumber = dao.updateOne(article);

        boolean result = false;

        if (rowNumber > 0) {result = true;}

        return result;
    }

    public boolean deleteOne(Long id) {
        int rowNumber = dao.deleteOne(id);

        boolean result = false;

        if (rowNumber > 0) {result = true;}

        return result;
    }

    public Article selectDistinctUserIdByUserId(String userId) {
        return dao.selectDistinctUserIdByUserId(userId);
    }

    public Article selectOneJoinMUserByUserId(Long id) {
        return dao.selectOneJoinMUserByUserId(id);
    }
}
