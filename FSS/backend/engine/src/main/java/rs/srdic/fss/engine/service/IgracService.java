package rs.srdic.fss.engine.service;

import rs.srdic.fss.model.Igrac;

import java.util.List;

public interface IgracService {

    Igrac saveOrUpdate(Igrac igrac);
    Igrac getOne(Integer igracID);
    void delete(Integer igracID);
    List<Igrac> findAll();

}
