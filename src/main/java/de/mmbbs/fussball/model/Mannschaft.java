package de.mmbbs.fussball.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MANNSCHAFT")
@Getter
@Setter
public class Mannschaft  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mannschaft_seq_gen")
    @SequenceGenerator(name = "mannschaft_seq_gen", sequenceName = "mannschaft_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    int id;

    @Column(name = "NAME")
    String name;

    @OneToMany
    @Column(name = "VERTRAG")
    List<Vertrag> vertragList;

    public Mannschaft(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Mannschaft() {

    }
}
