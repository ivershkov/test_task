package com.postgresqlrest.rest.dto;

public class InputBook {
    private Long id;
    private String bookname;
    private String isbn;
    private String theme;
    private Long[] authorsId;

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Long[] getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(Long[] authorsId) {
        this.authorsId = authorsId;
    }
}
