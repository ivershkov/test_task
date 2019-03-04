package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Books", schema = "public", catalog = "postgres")
public class Book {
    private Long id;
    private String bookname;

    @Basic
    @Column(name = "Id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bookname")
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
        return Objects.equals(id, that.id) &&
                Objects.equals(bookname, that.bookname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookname);
    }
}
