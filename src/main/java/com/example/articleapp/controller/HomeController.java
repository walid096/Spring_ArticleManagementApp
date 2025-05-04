package com.example.articleapp.controller;

import com.example.articleapp.entity.Article;
import com.example.articleapp.entity.User;
import com.example.articleapp.repository.ArticleRepository;
import com.example.articleapp.repository.UserRepository;

import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            Model model,
            Principal principal) {

        // Récupérer l'email de l'utilisateur connecté
        String email = principal.getName();

        // Trouver l'utilisateur
        User user = userRepository.findByEmail(email).orElseThrow();

        // Définir une spécification de recherche dynamique
        Specification<Article> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Ne montrer que les articles de l'utilisateur connecté
            predicates.add(cb.equal(root.get("creator"), user));

            if (description != null && !description.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("description")), "%" + description.toLowerCase() + "%"));
            }

            if (minPrice != null) {
                predicates.add(cb.ge(root.get("price"), minPrice));
            }

            if (maxPrice != null) {
                predicates.add(cb.le(root.get("price"), maxPrice));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        // Appliquer la spécification
        List<Article> userArticles = articleRepository.findAll(spec);

        // Ajouter au modèle
        model.addAttribute("username", user.getUsername());
        model.addAttribute("articles", userArticles);
        model.addAttribute("description", description);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);

        return "home";
    }
}
