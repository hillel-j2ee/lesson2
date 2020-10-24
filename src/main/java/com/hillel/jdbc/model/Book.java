package com.hillel.jdbc.model;

import java.util.List;

public class Book {
    private Long id;
    private String author;
    private List<String> genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("Book{%d, %s, %s}", id, author, printList(genre));
    }

    private String printList(List<String> list) {
        StringBuilder sb = new StringBuilder("{");
        list.stream().forEach(el -> sb.append(el).append(","));
        sb.deleteCharAt(sb.length() - 1);
        return sb.append("}").toString();
    }
}
