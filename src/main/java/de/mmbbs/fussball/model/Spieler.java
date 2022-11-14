package de.mmbbs.fussball.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "SPIELER")
public class Spieler {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @Column(name = "NAME")
    String name;

    @Column(name = "TRIKOTNUMMER")
    int trikotnummer;

    @Column(name = "POSITION")
    String position;

    @Column(name = "ELFMETER_GEHALTEN")
    int elfmeterGehalten;

    @OneToMany
    List<Treffer> treffer;
}
