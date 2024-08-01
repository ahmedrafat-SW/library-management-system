package com.dev.librarymanagementsystem.service;


import com.dev.librarymanagementsystem.model.BorrowingRecord;

public interface BorrowingService {

   BorrowingRecord borrowBook (Long bookId, Long patronId) throws Exception;

   BorrowingRecord returnBook(Long bookId, Long patronId) throws Exception;
}
