package com.postgresqlrest.rest.persistence.repository;

import com.postgresqlrest.rest.persistence.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AuthorRepository extends JpaRepository<Author,String> {
    public Author findAuthorById(Long id);
    public Author findAuthorByLastName(String name);
    void deleteAuthorByLastName(String name);
}
