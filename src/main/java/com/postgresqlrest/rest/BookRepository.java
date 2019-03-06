package com.postgresqlrest.rest;


import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RestResource(exported = false)
@Transactional
public interface BookRepository extends JpaRepository<Book, String> {
    public Book findBookByBookname(String name);

    void deleteBookByBookname(String name);
}
