package de.mmbbs.fussball.Repository;

import de.mmbbs.fussball.model.Vertrag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VertragRepository extends JpaRepository<Vertrag, Long> {
}
