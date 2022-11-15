package de.mmbbs.fussball.Repository;

import de.mmbbs.fussball.model.Spieler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpielerRepository extends JpaRepository<Spieler, Long> {
}
