package com.restpostgresql.resttest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.restpostgresql.resttest.Book;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


//@RestResource(exported = false)
public interface BookRepository extends JpaRepository<BooksEntity, String> {
    public BooksEntity findBookByBookname(String name);
}
