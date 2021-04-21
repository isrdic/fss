package rs.srdic.fss.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.srdic.fss.model.Utakmica;

@Repository
public interface UtakmicaRepository extends JpaRepository<Utakmica, Integer> {
}