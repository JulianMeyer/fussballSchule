package de.mmbbs.fussball.model;

import javax.persistence.*;


@Entity
@Table(name = "SCHIRI")
public class Schiri  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @Column(name = "NAME")
    String name;
}
