package de.mmbbs.fussball.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SPIELER")
@Getter
@Setter
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany( fetch = FetchType.EAGER)
    List<Treffer> treffer;

    public int getTrefferanzahl() {
        try {
            return treffer.size();
        } catch (Exception e) {
            return 0;
        }

    }
}
