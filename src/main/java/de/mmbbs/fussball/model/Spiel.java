package de.mmbbs.fussball.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
public class Spiel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mannschaft_seq_gen")
    @SequenceGenerator(name = "mannschaft_seq_gen", sequenceName = "mannschaft_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    int id;
    @Column(name = "VERTRAG")
    Mannschaft heim;
    @Column(name = "VERTRAG")
    Mannschaft auswaerts;
    @Column(name = "VERTRAG")
    Date date;
    @Column(name = "VERTRAG")
    Schiri schiri;
}
