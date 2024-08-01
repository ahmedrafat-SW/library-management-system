package com.dev.librarymanagementsystem.controller;

import com.dev.librarymanagementsystem.model.Patron;
import com.dev.librarymanagementsystem.service.PatronService;
import com.dev.librarymanagementsystem.util.LibraryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/patrons")
@RequiredArgsConstructor
public class PatronController {

    private final PatronService patronService;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatronById(@PathVariable Long id) {
        Patron patron = null;
        LibraryResponse libResponse = null;
        try{
             patron = patronService.getPatronById(id);
           return new ResponseEntity<>(new LibraryResponse<>(patron), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new LibraryResponse<>(patron), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addPatron(@RequestBody Patron patron) {
        Patron savedPatron = null;
        LibraryResponse libResponse = null;
        try {
            savedPatron = patronService.addPatron(patron);
            libResponse = new LibraryResponse(savedPatron);
            return new ResponseEntity<>(libResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(libResponse, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatron(@PathVariable Long id, @RequestBody Patron patron) {
        Patron oldPatron= null, updatedPatron = null;
        LibraryResponse libResponse = null;
        try{
            oldPatron = patronService.getPatronById(id);
            if (oldPatron != null){
                updatedPatron = patronService.updatePatron(id, patron);
            }
            return new ResponseEntity<>(new LibraryResponse<>(updatedPatron), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new LibraryResponse<>(updatedPatron), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}
