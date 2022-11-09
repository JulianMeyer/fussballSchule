package de.mmbbs.fussball.model;

import javax.persistence.*;

@Entity
@Table(name = "VERTRAG")
public class Vertrag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vertrag_seq_gen")
    @SequenceGenerator(name = "vertrag_seq_gen", sequenceName = "vertrag_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spieler_id")
    Spieler spieler;

    @Column(name = "GEHALT")
    Double gehalt;
}
