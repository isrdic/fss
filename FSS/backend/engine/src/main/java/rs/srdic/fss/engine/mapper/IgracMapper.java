package rs.srdic.fss.engine.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import rs.srdic.fss.engine.dto.IgracDTO;
import rs.srdic.fss.model.Igrac;

import java.util.List;

@Mapper
public interface IgracMapper {

    IgracMapper INSTANCE = Mappers.getMapper(IgracMapper.class);

    @Mappings({
            @Mapping(target = "slika", ignore = true),
            @Mapping(target = "mesto", ignore = true)
    })
    Igrac toIgrac(IgracDTO igracDTO);

//    @Mappings({
//            @Mapping(target = "slika", ignore = true)
//    })
    IgracDTO toIgracDTO(Igrac igrac);

    List<Igrac> toIgracList(List<IgracDTO> igracDTOList);
    List<IgracDTO> toIgracDTOList(List<Igrac> igracDTO);
}
