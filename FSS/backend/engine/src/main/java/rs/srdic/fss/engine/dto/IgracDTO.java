package rs.srdic.fss.engine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import rs.srdic.fss.model.enumeration.Pozicija;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IgracDTO {

    private Integer igracID;
    private String jmbg;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private MultipartFile slika;
    private Pozicija pozicija;

}
