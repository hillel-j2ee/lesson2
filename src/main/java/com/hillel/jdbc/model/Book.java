package com.hillel.jdbc.model;

import java.util.List;

public class Book {
    public static final String BOOK_TABLE = "book";
    public static final String NAME_COLUMN = "name";
    public static final String AUTHOR_COLUMN = "author";
    public static final String GENRE_COLUMN = "genre";

    private Long id;
    private String name;
    private String author;
    private String genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("Book{%d, %s, %s, %s}", id, name, author, genre);
    }
}
