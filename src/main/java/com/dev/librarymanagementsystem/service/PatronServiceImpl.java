package com.dev.librarymanagementsystem.service;

import com.dev.librarymanagementsystem.dao.PatronDao;
import com.dev.librarymanagementsystem.model.Book;
import com.dev.librarymanagementsystem.model.Patron;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PatronServiceImpl implements PatronService{

    private final PatronDao patronDao;


    @Override
    public List<Patron> getAllPatrons() {
        return patronDao.getAll();
    }

    @Override
    public Patron getPatronById(Long id) {
        return patronDao.getById(id);
    }

    @Override
    public Patron addPatron(Patron patron) {
        return patronDao.save(patron);
    }

    @Override
    public Patron updatePatron(Long id, Patron PatronDetails) {
        return patronDao.update(PatronDetails);
    }

    @Override
    public void deletePatron(Long id) {
        patronDao.delete(id);
    }
}
