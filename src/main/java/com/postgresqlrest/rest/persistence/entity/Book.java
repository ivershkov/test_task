package com.postgresqlrest.rest.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "book_name")
    private String bookname;
    @Basic
    @Column(name = "isbn")
    private String isbn;
    @Basic
    @Column(name = "theme")
    private String theme;
    @Basic
    @Column(name = "author_id")
    private Long authorId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return id == that.id &&
                Objects.equals(bookname, that.bookname);
    }

    @Override
    public String toString() {
        return String.format("id=%d , name=%s",id, bookname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookname);
    }
}
