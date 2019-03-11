package com.postgresqlrest.rest.persistence.repository;


import com.postgresqlrest.rest.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

//@RestResource(exported = false)
@Transactional
public interface BookRepository extends JpaRepository<Book, String> {
    public Book findBookById(Long id);

    public Iterable<Book> findBookByBookname(String name);

    @Query("select b from Book b where id in " +
            "(select a.bookId from Authorship a join Author b on a.authorId=b.id where b.lastName=?1)")
    public Iterable<Book> findBooksByLastName(String lastName);
    // public Iterable<Book> findBooksByAuthorFirstName(String name);
    // public Iterable<Book> findBooksByAuthorFirstNameAndAuthorMidNameAndAuthorLastName(String fn,String mn,String ln);
    void deleteBookByBookname(String name);

    void deleteBookById(Long id);

    @Query("select b from Book b where id in (select a.bookId from Authorship a where a.authorId = ?1)")
    List<Book> findBooksByAuthors(Long authorId);
}
