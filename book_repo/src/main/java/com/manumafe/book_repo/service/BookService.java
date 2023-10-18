package com.manumafe.book_repo.service;

import java.util.List;
import com.manumafe.book_repo.model.Book;

public interface BookService {
    public Book saveBook(Book book);

    public List<Book> getAllBooks();
}
