package rs.srdic.fss.engine.service;

import rs.srdic.fss.model.Utakmica;

import java.util.List;

public interface UtakmicaService {

    Utakmica saveOrUpdate(Utakmica utakmica);
    Utakmica getOne(Integer utakmicaID);
    void delete(Integer utakmicaID);
    List<Utakmica> findAll();
}
