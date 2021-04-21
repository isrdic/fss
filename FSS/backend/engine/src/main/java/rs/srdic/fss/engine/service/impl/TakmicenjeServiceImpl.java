package rs.srdic.fss.engine.service.impl;

import org.springframework.stereotype.Service;
import rs.srdic.fss.engine.repository.TakmicenjeRepository;
import rs.srdic.fss.engine.service.TakmicenjeService;

@Service
public class TakmicenjeServiceImpl implements TakmicenjeService {

    private final TakmicenjeRepository takmicenjeRepository;

    public TakmicenjeServiceImpl(TakmicenjeRepository takmicenjeRepository) {
        this.takmicenjeRepository = takmicenjeRepository;
    }
}
