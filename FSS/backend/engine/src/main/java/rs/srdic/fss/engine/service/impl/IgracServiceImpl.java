package rs.srdic.fss.engine.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.srdic.fss.engine.dto.IgracDTO;
import rs.srdic.fss.engine.mapper.IgracMapper;
import rs.srdic.fss.engine.repository.IgracRepository;
import rs.srdic.fss.engine.service.IgracService;
import rs.srdic.fss.model.Igrac;

import java.io.IOException;
import java.util.List;

@Service
public class IgracServiceImpl implements IgracService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IgracServiceImpl.class);

    private final IgracRepository igracRepository;

    @Autowired
    public IgracServiceImpl(IgracRepository igracRepository) {
        this.igracRepository = igracRepository;
    }

    @Override
    public IgracDTO saveOrUpdate(IgracDTO igracDTO) {
        try {
//            Igrac igrac = igracRepository.findById(igracDTO.getIgracID()).get();

            MultipartFile slika = igracDTO.getSlika();
            Byte[] byteObjects = new Byte[slika.getBytes().length];
            int i = 0;
            for (byte b : slika.getBytes()){
                byteObjects[i++] = b;
            }

            Igrac igrac = IgracMapper.INSTANCE.toIgrac(igracDTO);
//            igrac.setSlika(byteObjects);

            igracDTO = IgracMapper.INSTANCE.toIgracDTO(igracRepository.save(igrac));

            return igracDTO;
        } catch (IOException e) {
            //todo handle better
            LOGGER.error("Error occurred", e);

            e.printStackTrace();
            return null;
        }


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
