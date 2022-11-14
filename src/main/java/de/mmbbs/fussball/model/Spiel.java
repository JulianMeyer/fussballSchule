package de.mmbbs.fussball.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SPIEL")
public class Spiel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "heim_id")
    Mannschaft heim;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auswaerts_id")
    Mannschaft auswaerts;

    @Column(name = "DATE")
    Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Schiri_id")
    Schiri schiri;
}
