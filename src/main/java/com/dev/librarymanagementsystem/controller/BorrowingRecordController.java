package com.dev.librarymanagementsystem.controller;

import com.dev.librarymanagementsystem.model.Book;
import com.dev.librarymanagementsystem.model.BorrowingRecord;
import com.dev.librarymanagementsystem.service.BookService;
import com.dev.librarymanagementsystem.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class BorrowingRecordController {

    private final BorrowingService borrowingService;


    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<?> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {

        try{
            BorrowingRecord borrowingRecord = borrowingService.borrowBook(bookId, patronId);
            return new ResponseEntity<>(borrowingRecord, HttpStatus.OK);
        } catch (Exception e){
          e.printStackTrace();
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<?> updateBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        try {
            BorrowingRecord borrowingRecord = borrowingService.returnBook(bookId, patronId);
            return new ResponseEntity<>(borrowingRecord, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
