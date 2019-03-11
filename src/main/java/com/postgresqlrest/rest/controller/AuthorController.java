package com.postgresqlrest.rest.controller;

import com.postgresqlrest.rest.persistence.entity.Author;
import com.postgresqlrest.rest.persistence.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @GetMapping(path = "/findAll")
    public Iterable<Author> findAll(){return repository.findAll();}

    @GetMapping(path = "/findById")
    public Author findById(@RequestParam("id") Long id) {return repository.findAuthorById(id);}

/*    @GetMapping(path = "/findByTheme")
    public Iterable<Author> findByTheme(@RequestParam("theme") String theme) { return repository.findAuthorsByBookTheme(theme);}*/

    @GetMapping(path="/create")
    public Author create(@RequestParam("firstName") String firstName, @RequestParam("midName") String midName,
                         @RequestParam("lastName") String lastName, @RequestParam("birthDate") Date birthDate){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setMidName(midName);
        author.setLastName(lastName);
        author.setBirthDate(birthDate);
        return repository.save(author);
    }

    @GetMapping(path = "/delete")
    public String delete(@RequestParam("id") Long id){
        repository.deleteAuthorById(id);
        return "Successfully deleted";
    }

    //Добавить параметры для других полей таблицы
    @GetMapping(path ="/update")
    public String update(@RequestParam("id") Long id,@RequestParam("firstName") String firstName, @RequestParam("midName") String midName,
                         @RequestParam("lastName") String lastName, @RequestParam("birthDate") Date birthDate){
        Author author = repository.findAuthorById(id);
        author.setFirstName(firstName);
        author.setMidName(midName);
        author.setLastName(lastName);
        author.setBirthDate(birthDate);
        repository.save(author);
        return "Successfully updated";
    }
}
