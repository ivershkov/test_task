package com.postgresqlrest.rest.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "mid_name")
    private String midName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Set<Authorship> books = new HashSet<>();

    public Set<Authorship> getBooks() {
        return books;
    }

    public void setBooks(Set<Authorship> books) {
        this.books = books;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(midName, author.midName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(birthDate, author.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, midName, lastName, birthDate);
    }
}
