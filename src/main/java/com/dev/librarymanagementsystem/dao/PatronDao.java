package com.dev.librarymanagementsystem.dao;

import com.dev.librarymanagementsystem.model.Patron;
import org.springframework.stereotype.Repository;

@Repository
public class PatronDao extends BaseDao<Patron, Long> {

    public PatronDao() {
        super(Patron.class);
    }
}
