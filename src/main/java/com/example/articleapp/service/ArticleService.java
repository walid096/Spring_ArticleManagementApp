package com.example.articleapp.service;

import com.example.articleapp.entity.Article;
import com.example.articleapp.repository.ArticleRepository;
import com.example.articleapp.specification.ArticleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    // CRUD operations
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }
    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }


    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    // Multi-criteria search
    public List<Article> searchArticles(String description, BigDecimal minPrice, BigDecimal maxPrice) {
        // Check if description is empty or null before filtering
        if (description == null || description.isEmpty()) {
            return articleRepository.findAll(
                    ArticleSpecification.hasPriceBetween(minPrice, maxPrice)
            );
        }

        // Otherwise, apply the description filter along with the price range filter
        return articleRepository.findAll(
                ArticleSpecification.hasDescriptionContaining(description)
                        .and(ArticleSpecification.hasPriceBetween(minPrice, maxPrice))
        );
    }

    // Pagination-based method to fetch all articles
    public Page<Article> findAllArticles(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }
}
