package com.postgresqlrest.rest;


import org.springframework.data.jpa.repository.JpaRepository;

//@RestResource(exported = false)
public interface BookRepository extends JpaRepository<Book, String> {
    public Book findBookByBookname(String name);
}
