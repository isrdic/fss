package rs.srdic.fss.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.srdic.fss.engine.dto.NastupDTO;
import rs.srdic.fss.engine.repository.IgracRepository;
import rs.srdic.fss.engine.repository.NastupRepository;
import rs.srdic.fss.engine.repository.UtakmicaRepository;
import rs.srdic.fss.engine.service.NastupService;
import rs.srdic.fss.model.Igrac;
import rs.srdic.fss.model.Nastup;
import rs.srdic.fss.model.NastupID;
import rs.srdic.fss.model.Utakmica;

import java.util.List;

@Service
public class NastupServiceImpl implements NastupService {

    private final NastupRepository nastupRepository;
    private final IgracRepository igracRepository;
    private final UtakmicaRepository utakmicaRepository;

    @Autowired
    public NastupServiceImpl(NastupRepository nastupRepository, IgracRepository igracRepository, UtakmicaRepository utakmicaRepository) {
        this.nastupRepository = nastupRepository;
        this.igracRepository = igracRepository;
        this.utakmicaRepository = utakmicaRepository;
    }

    @Override
    public Nastup saveOrUpdate(NastupDTO nastupDTO) {
        Igrac igrac = igracRepository.findById(nastupDTO.getIgracID()).get();
        igrac.getNastupi();
        Utakmica utakmica = utakmicaRepository.findById(nastupDTO.getUtakmicaID()).get();
        utakmica.dodajIgraca(igrac, nastupDTO.getOcenaIgraca());
        utakmicaRepository.save(utakmica);
        return nastupRepository.getOne(new NastupID(nastupDTO.getIgracID(), nastupDTO.getUtakmicaID()));
    }

    @Override
    public Nastup getOne(NastupID nastupID) {
        return nastupRepository.getOne(nastupID);
    }

    @Override
    public void delete(NastupID nastupID) {

    }

    @Override
    public List<Utakmica> findAll(String jmbg) {
        return nastupRepository.findNastupiZaIgraca(jmbg);
    }
}
