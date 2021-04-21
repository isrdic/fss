package rs.srdic.fss.engine.service.impl;

import org.springframework.stereotype.Service;
import rs.srdic.fss.engine.repository.MestoRepository;
import rs.srdic.fss.engine.service.MestoService;
import rs.srdic.fss.model.Mesto;

import java.util.List;

@Service
public class MestoServiceImpl implements MestoService {

    private final MestoRepository mestoRepository;

    public MestoServiceImpl(MestoRepository mestoRepository) {
        this.mestoRepository = mestoRepository;
    }

    @Override
    public Mesto saveOrUpdate(Mesto mesto) {
        return mestoRepository.save(mesto);
    }

    @Override
    public Mesto getOne(Integer mestoID) {
        return mestoRepository.findById(mestoID).orElse(null);
    }

    @Override
    public void delete(Integer mestoID) {
        mestoRepository.deleteById(mestoID);
    }

    @Override
    public List<Mesto> findAll() {
        return mestoRepository.findAll();
    }
}
