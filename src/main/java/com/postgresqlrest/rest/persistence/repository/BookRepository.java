package com.postgresqlrest.rest.persistence.repository;


import com.postgresqlrest.rest.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RestResource(exported = false)
@Transactional
public interface BookRepository extends JpaRepository<Book, String> {
    public Book findBookById(Long id);
    public Book findBookByBookname(String name);
    public Iterable<Book> findBooksByAuthorFirstName(String name);
    void deleteBookByBookname(String name);
}
