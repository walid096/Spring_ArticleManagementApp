package com.example.articleapp.controller;

import com.example.articleapp.entity.Article;
import com.example.articleapp.entity.User;
import com.example.articleapp.repository.UserRepository;
import com.example.articleapp.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserRepository userRepository;



    // Formulaire de création
    @GetMapping("/articles/create")
    public String showCreateForm(Model model) {
        model.addAttribute("article", new Article());
        return "article_form";
    }

    // Création avec association de l'utilisateur
    @PostMapping("/articles")
    public String createArticle(@ModelAttribute Article article) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); // car tu utilises l'email pour l'auth
        User user = userRepository.findByEmail(email).orElseThrow();


        article.setCreator(user); // Associer le créateur
        articleService.createArticle(article);

        return "redirect:/home";
    }

    // Formulaire de recherche
    @GetMapping("/articles/search")
    public String showSearchForm() {
        return "article_search";
    }

    // Traitement de la recherche
    @PostMapping("/articles/search")
    public String searchArticles(@RequestParam String description,
                                 @RequestParam BigDecimal minPrice,
                                 @RequestParam BigDecimal maxPrice,
                                 Model model) {
        List<Article> articles = articleService.searchArticles(description, minPrice, maxPrice);
        model.addAttribute("articles", articles);
        return "article_search_results";
    }

    // Formulaire de modification
    @GetMapping("/articles/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "article_form";
    }

    // ✅ Mise à jour avec préservation du créateur
    @PostMapping("/articles/{id}")
    public String updateArticle(@PathVariable Long id, @ModelAttribute Article article) {
        Article existing = articleService.getArticleById(id);

        // Mise à jour des champs sauf 'creator'
        existing.setDescription(article.getDescription());
        existing.setPrice(article.getPrice());
        existing.setExpirationDate(article.getExpirationDate());
        existing.setStockQuantity(article.getStockQuantity());

        articleService.updateArticle(existing);
        return "redirect:/home"; // ✅ Redirection vers home
    }

    // Suppression
    @GetMapping("/articles/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/home"; // (facultatif : peut aussi aller vers /articles si préféré)
    }
}
