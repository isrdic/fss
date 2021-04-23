package rs.srdic.fss.engine.service;

import rs.srdic.fss.engine.dto.IgracDTO;
import rs.srdic.fss.engine.dto.NastupDTO;
import rs.srdic.fss.model.Igrac;
import rs.srdic.fss.model.Nastup;
import rs.srdic.fss.model.NastupID;

import java.util.List;

public interface NastupService {

    Nastup saveOrUpdate(NastupDTO nastupDTO);
    Nastup getOne(NastupID nastupID);
    void delete(NastupID nastupID);
    List<Nastup> findAll();

}
