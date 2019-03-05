package com.postgresqlrest.rest;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;
    @Basic
    @Column(name = "bookname")
    private String bookname;

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

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return id == that.id &&
                Objects.equals(bookname, that.bookname);
    }*/

    @Override
    public String toString() {
        return String.format("name=%s", bookname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookname);
    }
}
