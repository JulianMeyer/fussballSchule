package de.mmbbs.fussball.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Spieler extends Vertrag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mannschaft_seq_gen")
    @SequenceGenerator(name = "mannschaft_seq_gen", sequenceName = "mannschaft_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @Column(name = "VERTRAG")
    String name;
    @Column(name = "VERTRAG")
    int trikotnummer;
    @Column(name = "VERTRAG")
    String position;
    @Column(name = "VERTRAG")
    int elfmeterGehalten;

    @OneToMany
    List<Treffer> treffer;
}
