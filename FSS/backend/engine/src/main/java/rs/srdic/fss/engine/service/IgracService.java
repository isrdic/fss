package rs.srdic.fss.engine.service;

import rs.srdic.fss.engine.dto.IgracDTO;
import rs.srdic.fss.model.Igrac;

import java.util.List;

public interface IgracService {

    IgracDTO saveOrUpdate(IgracDTO igracDTO);
    Igrac getOne(Integer igracID);
    void delete(Integer igracID);
    List<Igrac> findAll();

}
