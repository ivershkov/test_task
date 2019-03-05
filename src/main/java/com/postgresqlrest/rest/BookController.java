package com.postgresqlrest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/books")
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/findAll")
    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/findBy")
    public Book find(@RequestParam("name") String name) {
        return repository.findBookByBookname(name);
    }
}
