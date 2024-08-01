package com.dev.librarymanagementsystem.service;

import com.dev.librarymanagementsystem.model.Patron;

import java.util.List;

public interface PatronService {


    List<Patron> getAllPatrons();

    Patron getPatronById(Long id);

    Patron addPatron(Patron patron);

    Patron updatePatron(Long id, Patron patronDetails);

    void deletePatron(Long id);
}
