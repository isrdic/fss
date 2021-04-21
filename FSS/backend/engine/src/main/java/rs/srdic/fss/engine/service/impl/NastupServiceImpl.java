package rs.srdic.fss.engine.service.impl;

import org.springframework.stereotype.Service;
import rs.srdic.fss.engine.repository.NastupRepository;
import rs.srdic.fss.engine.service.NastupService;

@Service
public class NastupServiceImpl implements NastupService {

    private final NastupRepository nastupRepository;

    public NastupServiceImpl(NastupRepository nastupRepository) {
        this.nastupRepository = nastupRepository;
    }
}
