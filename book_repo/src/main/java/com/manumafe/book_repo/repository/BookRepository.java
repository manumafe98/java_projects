package com.manumafe.book_repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manumafe.book_repo.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
