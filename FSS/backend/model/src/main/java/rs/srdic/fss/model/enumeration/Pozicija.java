package rs.srdic.fss.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Pozicija {

    CB(1,"Center Back"),
    CMF(2, "Center Midfielder Forward"),
    LB(3, "Left Back"),
    CF(4, "Centre Forward");

    private Integer pozicijaID;
    private String naziv;
}
