package rs.srdic.fss.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.srdic.fss.model.Nastup;
import rs.srdic.fss.model.NastupID;

@Repository
public interface NastupRepository extends JpaRepository<Nastup, NastupID> {
}