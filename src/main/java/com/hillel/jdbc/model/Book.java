package com.hillel.jdbc.model;

import java.util.List;

public class Book {
    public static final String TABLE_TITLE = "book";
    public static final String ID_COLUMN = "id";
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

    public static class Builder {
        private Book newBook;

        public Builder() {
            newBook = new Book();
        }

        public Builder withId(Long id) {
            newBook.id = id;
            return this;
        }

        public Builder withName(String name) {
            newBook.name = name;
            return this;
        }

        public Builder withAuthor(String author) {
            newBook.author = author;
            return this;
        }

        public Builder withGenre(String genre) {
            newBook.genre = genre;
            return this;
        }

        public Book build(){
            return newBook;
        }
    }
}
