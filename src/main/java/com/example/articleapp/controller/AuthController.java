package com.example.articleapp.controller;

import com.example.articleapp.entity.User;
import com.example.articleapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Affiche la page de connexion
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // src/main/resources/templates/login.html
    }

    // Affiche la page d'inscription
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // src/main/resources/templates/register.html
    }

    // Traite le formulaire d'inscription
    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               Model model,
                               HttpServletRequest request) throws ServletException {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Les mots de passe ne correspondent pas.");
            model.addAttribute("user", new User());
            return "register";
        }

        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Nom d'utilisateur déjà utilisé.");
            model.addAttribute("user", new User());
            return "register";
        }

        // Création de l'utilisateur
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        // Connexion automatique après inscription (email est l’identifiant utilisé par Spring Security)
        request.login(email, password);

        return "redirect:/home";
    }

}
