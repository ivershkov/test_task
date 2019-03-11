package com.postgresqlrest.rest.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Set<Authorship> authors = new HashSet<>();

    public Set<Authorship> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Authorship> authors) {
        this.authors = authors;
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
