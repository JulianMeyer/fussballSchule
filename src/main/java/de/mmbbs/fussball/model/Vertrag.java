package de.mmbbs.fussball.model;

import javax.persistence.*;

@Entity
@Table(name = "VERTRAG")
public class Vertrag {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spieler_id")
    Spieler spieler;

    @Column(name = "GEHALT")
    Double gehalt;
}
