package de.mmbbs.fussball.Repository;

import de.mmbbs.fussball.model.Mannschaft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MannschaftRepository extends JpaRepository<Mannschaft, Long> {
}
