package com.postgresqlrest.rest.controller;

import com.postgresqlrest.rest.persistence.entity.Book;
import com.postgresqlrest.rest.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/findAll")
    public Iterable<Book> findAll() { return repository.findAll(); }

    @GetMapping(path = "/findBy")
    public Book find(@RequestParam("name") String name) { return repository.findBookByBookname(name); }

    @GetMapping(path = "/findByAuthor")
    public Iterable<Book> findByAuthor(@RequestParam("firstName") String name) { return repository.findBooksByAuthorFirstName(name); }

    //Добавить параметры для других полей таблицы
    @GetMapping(path="/create")
    public Book create(@RequestParam("name") String name) {
          Book book = new Book();
          book.setBookname(name);
          return repository.save(book);
    }

    @GetMapping(path = "/deleteBy")
    public String delete(@RequestParam("name") String name) {
        repository.deleteBookByBookname(name);
        return "Successfully deleted";
    }

    //Добавить параметры для других полей таблицы
    @GetMapping(path="/update")
    public String update(@RequestParam("id") Long id, @RequestParam("name") String name)
    {
        Book book = repository.findBookById(id);
        book.setBookname(name);
        repository.save(book);
        return "Successfully updated";
    }
}
