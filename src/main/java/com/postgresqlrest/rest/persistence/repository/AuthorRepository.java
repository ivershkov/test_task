package com.postgresqlrest.rest.persistence.repository;

import com.postgresqlrest.rest.persistence.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;


@Transactional
public interface AuthorRepository extends JpaRepository<Author,String> {
    public Author findAuthorById(Long id);

    public Iterable<Author> findAuthorsByLastName(String lastName);
    @Query("select a from Author a join Authorship b on a.id = b.author.id where b.id in (select a.id" +
            " from Authorship a join Book b on b.id=a.book.id where b.theme=?1)")
    public Iterable<Author> findAuthorsByBookTheme(String t);
    void deleteAuthorByLastName(String name);
    void deleteAuthorById(Long id);
}
