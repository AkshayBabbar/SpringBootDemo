package com.Starter.SpringDemo.bootstrap;

import com.Starter.SpringDemo.model.Author;
import com.Starter.SpringDemo.model.Book;
import com.Starter.SpringDemo.model.Publisher;
import com.Starter.SpringDemo.repositories.AuthorRepository;
import com.Starter.SpringDemo.repositories.BookRepository;
import com.Starter.SpringDemo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    private void initData(){
        Publisher harperCollins = new Publisher();
        harperCollins.setName("Harper Collins");
        publisherRepository.save(harperCollins);

        Publisher worx = new Publisher("Worx");
        publisherRepository.save(worx);

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        // noEJB.getAuthors().add(rod);
        noEJB.setPublisher(worx);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
