package rs.srdic.fss.engine.service;

import rs.srdic.fss.model.Mesto;

import java.util.List;

public interface MestoService {

    Mesto saveOrUpdate(Mesto mesto);
    Mesto getOne(Integer mestoID);
    void delete(Integer mestoID);
    List<Mesto> findAll();
}
