package com.dev.librarymanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.dev.librarymanagementsystem.dao.BorrowingRecordDao;
import com.dev.librarymanagementsystem.model.Book;
import com.dev.librarymanagementsystem.model.BorrowingRecord;
import com.dev.librarymanagementsystem.model.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class BorrowingRecordServiceTest {

    @Mock
    private BorrowingRecordDao recordDao;

    @Mock
    private BookServiceImpl bookService;

    @Mock
    private PatronServiceImpl patronService;

    @InjectMocks
    private BorrowingServiceImpl borrowingRecordService;

    private Book book;
    private Patron patron;
    private BorrowingRecord borrowingRecord;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setPublicationYear(2023);
        book.setIsbn("1234567890123");

        patron = new Patron();
        patron.setId(1L);
        patron.setName("Test Patron");
        patron.setContactInformation("test@contact.com");

        borrowingRecord = new BorrowingRecord();
        borrowingRecord.setId(1L);
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowDate(LocalDate.now());
    }

    @Test
    public void testBorrowBook() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(book);
        when(patronService.getPatronById(1L)).thenReturn(patron);
        when(recordDao.save(any(BorrowingRecord.class)))
                .thenReturn(borrowingRecord);

        BorrowingRecord record = borrowingRecordService.borrowBook(1L, 1L);
        assertNotNull(record);
        assertEquals(book, record.getBook());
        assertEquals(patron, record.getPatron());
    }

    @Test
    public void testReturnBook() throws Exception {
        when(borrowingRecordService
                .returnBook(1L, 1L))
                .thenReturn(borrowingRecord);
        when(recordDao.save(any(BorrowingRecord.class)))
                .thenReturn(borrowingRecord);

        BorrowingRecord record = borrowingRecordService.returnBook(1L, 1L);
        assertNotNull(record.getReturnDate());
    }
}
