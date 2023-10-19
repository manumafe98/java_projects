package com.manumafe.book_repo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manumafe.book_repo.model.Book;
import com.manumafe.book_repo.model.BookStatus;
import com.manumafe.book_repo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBooksByStatus(BookStatus status) {
        return bookRepository.findByBookStatus(status);
    }
}
