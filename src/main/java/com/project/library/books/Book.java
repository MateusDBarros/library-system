package com.project.library.books;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;

    private String name;
    private String author;
    private String category;
    private LocalDate published;

    public Book() {
    }

    public Book(String name, String author, String category, LocalDate published) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.published = published;
    }


    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }
}
