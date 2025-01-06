package com.project.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepo bookRepository;

    @Autowired
    public BookService(BookRepo service) {
        this.bookRepository = service;
    }

    // Create Book
    public void createBook(Book book) {

        // Exceptions to handle missing data
        if (book.getName() == null || book.getName().isEmpty())
            throw new IllegalStateException("Item must have a name.");
        if (book.getAuthor() == null || book.getAuthor().isEmpty())
            throw new IllegalStateException("Item must have a authors name.");
        if (book.getCategory() == null || book.getCategory().isEmpty())
            throw new IllegalStateException("Item must have a category.");
        if (book.getPublished() == null)
            throw new IllegalStateException("Item must have a published date.");

        Optional<Book> bookOptional = bookRepository.findByName(book.getName());
        if (bookOptional.isPresent())
            throw new IllegalStateException("Book name already taken");

        bookRepository.save(book);
    }

    // Read Book
    public List<Book> readBook() {
        return bookRepository.findAll();
    }

    // Update Book
    @Transactional
    public void updateBook(Long bookID, String name) {
        Book book = bookRepository.findByName(name).orElseThrow(() -> new IllegalStateException("Book name " +name+ " not exist."));

        if (name != null && name.isEmpty() && !Objects.equals(book.getName(), name))
            book.setName(name);
    }
    // Delete Book
    public void deleteBook(Long bookID) {
        boolean exist = bookRepository.existsById(bookID);

        if (!exist)
            throw new IllegalStateException("Book ID " +bookID+ " not found");
        bookRepository.deleteById(bookID);
        System.out.println("Book " +bookID+ " deleted sucessfully");
    }
}
