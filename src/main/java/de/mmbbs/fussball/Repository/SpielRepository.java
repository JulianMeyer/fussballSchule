package de.mmbbs.fussball.Repository;

import de.mmbbs.fussball.model.Spiel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpielRepository extends JpaRepository<Spiel, Long> {
}
