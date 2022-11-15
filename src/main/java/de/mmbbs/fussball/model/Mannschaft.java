package de.mmbbs.fussball.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MANNSCHAFT")
@Getter
@Setter
public class Mannschaft  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    public int getVertragAnzahl(){
        try {
            return vertragList.size();
        } catch (Exception e) {
            return 0;
        }
    }
}
