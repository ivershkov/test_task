package com.example.restservice.controller;

import com.example.entity.Book;
import com.example.restservice.repository.BookRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/books")
public class BookController {
/*
    @Autowired
    private BookRepository repository;

    @GetMapping
    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{bookname}")
    public Book find(@PathVariable("bookname") String bookname) {
        return repository.findOne(bookname);
    }

    @PostMapping(consumes = "application/json")
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping(path = "/{bookname}")
    public void delete(@PathVariable("bookname") String bookname) {
        repository.delete(repository.findByName(bookname));
    }

    @PutMapping(path = "/{bookname}")
    public Book update(@PathVariable("bookname") String bookname,
                       @RequestBody Book book) throws BadHttpRequest {
        if (repository.exists(bookname)) {
            book.setBookname(bookname);
            return repository.save(book);
        } else {
            throw new BadHttpRequest();
        }
    }
*/
}
