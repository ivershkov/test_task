package com.restpostgresql.resttest;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Books", schema = "public")
public class BooksEntity {
    private long id;
    private String bookname;

    @Id
    @Column(name = "Id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        BooksEntity that = (BooksEntity) o;
        return id == that.id &&
                Objects.equals(bookname, that.bookname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookname);
    }
}
