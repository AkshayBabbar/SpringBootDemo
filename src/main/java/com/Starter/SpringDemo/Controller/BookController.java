package com.Starter.SpringDemo.Controller;

import com.Starter.SpringDemo.repositories.BookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/books")
    public  String getBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());

        return "books";

    }
}
