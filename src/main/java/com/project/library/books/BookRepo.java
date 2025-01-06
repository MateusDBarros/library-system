package com.project.library.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo  extends JpaRepository<Book, Long>{
    Optional<Book> findByName(String name);
}
