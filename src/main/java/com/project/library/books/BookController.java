package com.project.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/library")
public class BookController {

    private final BookService services;

    @Autowired
    public BookController(BookService services) {
        this.services = services;
    }

    // Create Book
    @PostMapping
    public void addNew(@RequestBody Book b) {
        services.createBook(b);
    }

    // Read Book
    @GetMapping
    public List<Book> getBook() {
        return services.readBook();
    }

    // Update Book
    @PutMapping(path = "{bookID}")
    public void updateBook(@PathVariable("bookID") Long bookID,
                           @RequestParam(required = false) String name) {
        services.updateBook(bookID, name);
    }



    // Delete Book
    @DeleteMapping
    public void deleteBook(@PathVariable("bookID") Long bookID) {
        services.deleteBook(bookID);
    }
}
