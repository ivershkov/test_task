package com.restpostgresql.resttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.restpostgresql.resttest.BookRepository;
import com.restpostgresql.resttest.Book;

@RestController
@RequestMapping(path = "/books")
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/findAll")
    public Iterable<BooksEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/findBy")
    public BooksEntity find(@RequestParam("name") String name) {
        return repository.findBookByBookname(name);
    }
}
