package com.postgresqlrest.rest.persistence.repository;

import com.postgresqlrest.rest.persistence.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AuthorRepository extends JpaRepository<Author,String> {
    public Author findAuthorById(Long id);

    public Iterable<Author> findAuthorsByLastName(String lastName);
    @Query("select a from Author a join Book b on a.id = b.author.id where b.theme = ?1")
    public Iterable<Author> findAuthorsByBookTheme(String t);
    void deleteAuthorByLastName(String name);
    void deleteAuthorById(Long id);
}
