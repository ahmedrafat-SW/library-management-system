package com.dev.librarymanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.dev.librarymanagementsystem.dao.PatronDao;
import com.dev.librarymanagementsystem.model.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class PatronServiceTest {

    @Mock
    private PatronDao patronDao;

    @InjectMocks
    private PatronServiceImpl patronService;

    private Patron patron;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        patron = new Patron();
        patron.setId(1L);
        patron.setName("Test Patron");
        patron.setContactInformation("test@contact.com");
    }

    @Test
    public void testGetAllPatrons() {
        when(patronDao.getAll()).thenReturn(Arrays.asList(patron));
        List<Patron> patrons = patronService.getAllPatrons();
        assertEquals(1, patrons.size());
        assertEquals(patron, patrons.get(0));
    }

    @Test
    public void testGetPatronById() {
        when(patronDao.getById(1L)).thenReturn(patron);
        Patron foundPatron = patronService.getPatronById(1L);
        assertEquals(patron, foundPatron);
    }

    @Test
    public void testAddPatron() {
        when(patronDao.save(patron)).thenReturn(patron);
        Patron savedPatron = patronService.addPatron(patron);
        assertEquals(patron, savedPatron);
    }

    @Test
    public void testUpdatePatron() {
        when(patronDao.getById(1L)).thenReturn(patron);
        when(patronDao.save(patron)).thenReturn(patron);
        patron.setName("Updated Patron");
        Patron updatedPatron = patronService.updatePatron(1L, patron);
        assertEquals("Updated Patron", updatedPatron.getName());
    }

    @Test
    public void testDeletePatron() {
        patronService.deletePatron(1L);
        verify(patronDao, times(1)).delete(1L);
    }
}
