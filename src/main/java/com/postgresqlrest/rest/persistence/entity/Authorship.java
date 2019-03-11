package com.postgresqlrest.rest.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Authorship {
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "author_id")
    private Long authorId;

    @Basic
    @Column(name = "book_id")
    private Long bookId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorship that = (Authorship) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
