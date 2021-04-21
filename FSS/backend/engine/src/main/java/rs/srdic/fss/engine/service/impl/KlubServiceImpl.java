package rs.srdic.fss.engine.service.impl;

import org.springframework.stereotype.Service;
import rs.srdic.fss.engine.repository.KlubRepository;
import rs.srdic.fss.engine.service.KlubService;
import rs.srdic.fss.model.Klub;

import java.util.List;

@Service
public class KlubServiceImpl implements KlubService {

    private final KlubRepository klubRepository;

    public KlubServiceImpl(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    @Override
    public Klub saveOrUpdate(Klub klub) {
        return klubRepository.save(klub);
    }

    @Override
    public Klub getOne(Integer klubID) {
        return klubRepository.findById(klubID).orElse(null);
    }

    @Override
    public void delete(Integer klubID) {
        klubRepository.deleteById(klubID);
    }

    @Override
    public List<Klub> findAll() {
        return klubRepository.findAll();
    }
}
