package com.Starter.SpringDemo.Controller;

import com.Starter.SpringDemo.repositories.AuthorRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors",authorRepository.findAll());
        return "authors";
    }
}
