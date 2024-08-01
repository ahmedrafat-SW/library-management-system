package com.dev.librarymanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.dev.librarymanagementsystem.dao.BookDao;
import com.dev.librarymanagementsystem.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class BookServiceTest {

    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book book;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setPublicationYear(2023);
        book.setIsbn("1234567890123");
    }

    @Test
    public void testGetAllBooks() {
        when(bookDao.getAll()).thenReturn(Arrays.asList(book));
        List<Book> books = bookService.getAllBooks();
        assertEquals(1, books.size());
        assertEquals(book, books.get(0));
    }

    @Test
    public void testGetBookById() {
        when(bookDao.getById(1L)).thenReturn(book);
        Book foundBook = bookService.getBookById(1L);
        assertEquals(book, foundBook);
    }

    @Test
    public void testAddBook() {
        when(bookDao.save(book)).thenReturn(book);
        Book savedBook = bookService.addBook(book);
        assertEquals(book, savedBook);
    }

    @Test
    public void testUpdateBook() {
        when(bookDao.getById(1L)).thenReturn(book);
        when(bookDao.save(book)).thenReturn(book);
        book.setTitle("Updated Book");
        Book updatedBook = bookService.updateBook(1L, book);
        assertEquals("Updated Book", updatedBook.getTitle());
    }

    @Test
    public void testDeleteBook() {
        bookService.deleteBook(1L);
        verify(bookDao, times(1)).delete(1L);
    }
}

