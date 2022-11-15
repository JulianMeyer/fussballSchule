package de.mmbbs.fussball.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "VERTRAG")
@Getter
@Setter
public class Vertrag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "spieler_id")
    Spieler spieler;

    @Column(name = "GEHALT")
    Double gehalt;
}
