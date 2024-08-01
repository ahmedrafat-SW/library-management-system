package com.dev.librarymanagementsystem.service;

import com.dev.librarymanagementsystem.dao.BorrowingRecordDao;
import com.dev.librarymanagementsystem.model.Book;
import com.dev.librarymanagementsystem.model.BorrowingRecord;
import com.dev.librarymanagementsystem.model.Patron;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService{

    private final BorrowingRecordDao borrowingDao;
    private final BookService bookService;
    private final PatronService patronService;
    private final BorrowingRecordDao borrowingRecordDao;

    @Override
    public BorrowingRecord borrowBook(Long bookId, Long patronId) throws Exception {
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        Book book = bookService.getBookById(bookId);
        Patron patron = patronService.getPatronById(patronId);
        if (book == null || patron == null){
            throw new EntityNotFoundException("book or patron doesn't exist");
        }
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowDate(LocalDate.now());

        return borrowingDao.save(borrowingRecord);
    }

    @Override
    public BorrowingRecord returnBook(Long bookId, Long patronId) throws Exception {
        BorrowingRecord borrowingRecord = new BorrowingRecord();

        Book book = bookService.getBookById(bookId);
        Patron patron = patronService.getPatronById(patronId);
        if (book == null || patron == null){
            throw new EntityNotFoundException("book or patron doesn't exist");
        }
        BorrowingRecord record = borrowingDao.getBorrowingRecordBy(bookId, patronId);
        record.setReturnDate(LocalDate.now());

        return borrowingRecordDao.save(record);
    }
}
