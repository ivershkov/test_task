package com.postgresqlrest.rest.controller;

import com.postgresqlrest.rest.persistence.entity.Author;
import com.postgresqlrest.rest.persistence.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @GetMapping(path = "/findAll")
    public Iterable<Author> findAll(){return repository.findAll();}

    @GetMapping(path = "/findBy")
    public Author find(@RequestParam("id") Long id) {return repository.findAuthorById(id);}

    //Добавить параметры для других полей таблицы
    @GetMapping(path="/create")
    public Author create(@RequestParam("lastName") String lastName){
        Author author = new Author();
        author.setLastName(lastName);
        return repository.save(author);
    }

    @GetMapping(path = "/deleteBy")
    public String delete(@RequestParam("lastName") String lastName){
        repository.deleteAuthorByLastName(lastName);
        return "Successfully deleted";
    }

    //Добавить параметры для других полей таблицы
    @GetMapping(path ="/update")
    public String update(@RequestParam("id") Long id,@RequestParam("lastName") String lastName){
        Author author = repository.findAuthorById(id);
        author.setLastName(lastName);
        repository.save(author);
        return "Successfully updated";
    }
}
