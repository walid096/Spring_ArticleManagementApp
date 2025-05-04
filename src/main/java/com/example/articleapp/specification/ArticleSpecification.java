package com.example.articleapp.specification;

import com.example.articleapp.entity.Article;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ArticleSpecification {

    // Search by description (like keyword search)
    public static Specification<Article> hasDescriptionContaining(String keyword) {
        return (root, query, builder) ->
                keyword == null ? null : builder.like(root.get("description"), "%" + keyword + "%");
    }

    // Search by price range
    public static Specification<Article> hasPriceBetween(BigDecimal min, BigDecimal max) {
        return (root, query, builder) -> {
            if (min != null && max != null) {
                return builder.between(root.get("price"), min, max);
            } else if (min != null) {
                return builder.greaterThanOrEqualTo(root.get("price"), min);
            } else if (max != null) {
                return builder.lessThanOrEqualTo(root.get("price"), max);
            } else {
                return null;
            }
        };
    }
}
