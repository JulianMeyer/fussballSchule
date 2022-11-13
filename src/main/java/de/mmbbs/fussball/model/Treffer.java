package de.mmbbs.fussball.model;

import javax.persistence.*;

@Entity
@Table(name = "TREFFER")
public class Treffer  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mannschaft_seq_gen")
    @SequenceGenerator(name = "mannschaft_seq_gen", sequenceName = "mannschaft_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @Column(name = "MINUTE")
    int minute;

    @Column(name = "IS_EIGENTOR")
    boolean isEigentor;
}
