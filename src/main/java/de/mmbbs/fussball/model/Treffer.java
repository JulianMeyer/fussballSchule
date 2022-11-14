package de.mmbbs.fussball.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "TREFFER")
@Getter
public class Treffer  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @Column(name = "MINUTE")
    int minute;

    @Column(name = "IS_EIGENTOR")
    boolean isEigentor;

    public Treffer() {

    }
}
