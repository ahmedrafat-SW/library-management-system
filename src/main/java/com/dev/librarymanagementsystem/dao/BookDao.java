package com.dev.librarymanagementsystem.dao;

import com.dev.librarymanagementsystem.model.Book;
import org.springframework.stereotype.Repository;


@Repository
public class BookDao extends BaseDao<Book,Long> {

    public BookDao() {
        super(Book.class);
    }

}
