package de.mmbbs.fussball.Repository;

import de.mmbbs.fussball.model.Treffer;
import org.springframework.data.repository.CrudRepository;

public interface TrefferRepository extends CrudRepository<Treffer, Long> {

    Treffer findById(int id);
}
