package com.dev.librarymanagementsystem.service;

import com.dev.librarymanagementsystem.dao.BookDao;
import com.dev.librarymanagementsystem.model.Book;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookDao bookDao;


    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookDao.getById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        return bookDao.update(bookDetails);
    }

    public void deleteBook(Long id) {
        bookDao.delete(id);
    }
}
