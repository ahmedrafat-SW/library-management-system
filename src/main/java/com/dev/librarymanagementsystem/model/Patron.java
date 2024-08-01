package com.dev.librarymanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PATRON")
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATRON_ID")
    private Long id;

    @Column(name = "PATRON_NAME")
    private String name;

    @Column(name = "CONTACT_IFORMATION")
    private String contactInformation;
}
