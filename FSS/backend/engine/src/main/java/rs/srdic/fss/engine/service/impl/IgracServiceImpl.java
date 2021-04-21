package rs.srdic.fss.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.srdic.fss.engine.repository.IgracRepository;
import rs.srdic.fss.engine.service.IgracService;
import rs.srdic.fss.model.Igrac;

import java.util.List;

@Service
public class IgracServiceImpl implements IgracService {

    private final IgracRepository igracRepository;

    @Autowired
    public IgracServiceImpl(IgracRepository igracRepository) {
        this.igracRepository = igracRepository;
    }

    @Override
    public Igrac saveOrUpdate(Igrac igrac) {
        return igracRepository.save(igrac);
    }

    @Override
    public Igrac getOne(Integer igracID) {
        return igracRepository.findById(igracID).orElse(null);
    }

    @Override
    public void delete(Integer igracID) {
        igracRepository.deleteById(igracID);
    }

    @Override
    public List<Igrac> findAll() {
        return igracRepository.findAll();
    }

}
