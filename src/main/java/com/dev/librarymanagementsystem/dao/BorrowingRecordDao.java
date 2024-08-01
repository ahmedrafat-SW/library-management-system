package com.dev.librarymanagementsystem.dao;

import com.dev.librarymanagementsystem.model.BorrowingRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BorrowingRecordDao extends BaseDao<BorrowingRecord, Long> {

    public BorrowingRecordDao(){
        super(BorrowingRecord.class);
    }

    public BorrowingRecord getBorrowingRecordBy(Long bookId, Long patronId){
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("select b from BorrowingRecord b " +
                "where b.book.id =: bookId and b.patron.id =: patronId", BorrowingRecord.class);

        query.setParameter("bookId", bookId);
        query.setParameter("patronId", patronId);

        return (BorrowingRecord) query.getSingleResult();
    }
}