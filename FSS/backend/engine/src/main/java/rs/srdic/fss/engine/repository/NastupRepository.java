package rs.srdic.fss.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.srdic.fss.model.Korisnik;
import rs.srdic.fss.model.Nastup;
import rs.srdic.fss.model.NastupID;
import rs.srdic.fss.model.Utakmica;

import java.util.List;

@Repository
public interface NastupRepository extends JpaRepository<Nastup, NastupID> {

    @Query("select u from Igrac i, Utakmica u, Nastup n where n.igracID = i.igracID and m.utakmicaID=u.utakmicaID and i.jmbg=:jmbg")
    List<Utakmica> findNastupiZaIgraca(String jmbg);

}