package rs.srdic.fss.engine.service.impl;

import org.springframework.stereotype.Service;
import rs.srdic.fss.engine.repository.UtakmicaRepository;
import rs.srdic.fss.engine.service.UtakmicaService;
import rs.srdic.fss.model.Utakmica;

import java.util.List;

@Service
public class UtakmicaServiceImpl implements UtakmicaService {

    private final UtakmicaRepository utakmicaRepository;

    public UtakmicaServiceImpl(UtakmicaRepository utakmicaRepository) {
        this.utakmicaRepository = utakmicaRepository;
    }

    @Override
    public Utakmica saveOrUpdate(Utakmica utakmica) {
        return utakmicaRepository.save(utakmica);
    }

    @Override
    public Utakmica getOne(Integer utakmicaID) {
        return utakmicaRepository.findById(utakmicaID).orElse(null);
    }

    @Override
    public void delete(Integer utakmicaID) {
        utakmicaRepository.deleteById(utakmicaID);
    }

    @Override
    public List<Utakmica> findAll() {
        return utakmicaRepository.findAll();
    }
}
