package com.postgresqlrest.rest.controller;

import com.postgresqlrest.rest.persistence.entity.Authorship;
import com.postgresqlrest.rest.persistence.entity.Book;
import com.postgresqlrest.rest.dto.InputBook;
import com.postgresqlrest.rest.persistence.repository.AuthorshipRepository;
import com.postgresqlrest.rest.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.StringTokenizer;


@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorshipRepository authorshipRepository;

    @GetMapping("/findAll")
    public Iterable<Book> findAll() { return bookRepository.findAll(); }

    @GetMapping(path = "/findByName")
    public Iterable<Book> find(@RequestParam("name") String name) { return bookRepository.findBookByBookname(name); }

    @GetMapping(path = "/findByAuthor")
    public Iterable<Book> findByAuthor(@RequestParam("firstName")String firstName,
                                       @RequestParam("midName")String midName,@RequestParam("lastName")String lastName)
    { return bookRepository.findBooksByLastName(firstName,midName,lastName);}



    @GetMapping(path = "/delete")
    public String delete(@RequestParam("id") Long id) {
        authorshipRepository.deleteAuthorshipsByBookId(id);
        bookRepository.deleteBookById(id);
        return "Successfully deleted";
    }

    @GetMapping(path="/update")
    public String update(@RequestParam("id") Long id, @RequestParam("name") String name,@RequestParam("isbn") String isbn,
                         @RequestParam("theme") String theme,@RequestParam("authorId") String authorId)
    {
        Book book = bookRepository.findBookById(id);
        book.setBookname(name);
        book.setIsbn(isbn);
        book.setTheme(theme);
        bookRepository.save(book);
        authorshipRepository.deleteAuthorshipsByBookId(book.getId());
        createAuthorship(book,authorId);
        return "Successfully updated";
    }

    @PostMapping
    public Book create(@RequestBody InputBook inputBook){
        Book book = new Book();
        book.setId(inputBook.getId());
        book.setBookname(inputBook.getBookname());
        book.setIsbn(inputBook.getIsbn());
        book.setTheme(inputBook.getTheme());
        bookRepository.save(book);
        Long[] ids=inputBook.getAuthorsId();
        for(int i = 0;i<ids.length;i++){
            Authorship authorship = new Authorship();
            authorship.setBookId(book.getId());
            authorship.setAuthorId(ids[i]);
            authorshipRepository.save(authorship);
        }
        return bookRepository.findBookById(book.getId());
    }

        @GetMapping(path="/create")
    public Book create(@RequestParam("name") String name,@RequestParam("isbn") String isbn,
                       @RequestParam("theme") String theme,@RequestParam("authorId") String authorId) {
          Book book = new Book();
          book.setBookname(name);
          book.setIsbn(isbn);
          book.setTheme(theme);
          bookRepository.save(book);
          createAuthorship(book,authorId);
          return bookRepository.findBookById(book.getId());
    }

    private void createAuthorship(Book b,String s){
        StringTokenizer stk = new StringTokenizer(s,",");
        String []ids = new String[stk.countTokens()];
        for(int i = 0; i<ids.length;i++){
            ids[i]=stk.nextToken();
            Authorship authorship = new Authorship();
            authorship.setBookId(b.getId());
            authorship.setAuthorId(Long.valueOf(ids[i]));
            authorshipRepository.save(authorship);
        }
    }
}
