package com.example.restservice.repository;

import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface BookRepository extends JpaRepository<Book, String> {
    Book findByName(String name);
}
