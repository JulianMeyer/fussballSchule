package de.mmbbs.fussball.Repository;

import de.mmbbs.fussball.model.Treffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrefferRepository extends JpaRepository<Treffer, Long> {

    Treffer findById(int id);
}
