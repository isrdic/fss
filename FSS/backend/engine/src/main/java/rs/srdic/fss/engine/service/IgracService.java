package rs.srdic.fss.engine.service;

import org.springframework.web.multipart.MultipartFile;
import rs.srdic.fss.engine.dto.IgracDTO;
import rs.srdic.fss.model.Igrac;

import java.io.IOException;
import java.util.List;

public interface IgracService {

    IgracDTO save(IgracDTO igracDTO) throws IOException;
    IgracDTO update(IgracDTO igracDTO);
    Igrac getOne(Integer igracID);
    void delete(Integer igracID);
    List<Igrac> findAll();

}
