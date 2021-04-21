package rs.srdic.fss.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.srdic.fss.model.Mesto;

@Repository
public interface MestoRepository extends JpaRepository<Mesto, Integer> {
}