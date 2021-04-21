package rs.srdic.fss.engine.service;

import rs.srdic.fss.model.Klub;

import java.util.List;

public interface KlubService {

    Klub saveOrUpdate(Klub klub);
    Klub getOne(Integer klubID);
    void delete(Integer klubID);
    List<Klub> findAll();

}
