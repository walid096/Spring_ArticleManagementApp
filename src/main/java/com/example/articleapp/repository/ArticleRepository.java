package com.example.articleapp.repository;

import com.example.articleapp.entity.Article;
import com.example.articleapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
    List<Article> findByCreator(User creator);
}
