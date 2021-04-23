package rs.srdic.fss.model.enumeration;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PozicijaItem {

    private Pozicija id;
    private String text;
    private String slug;

}
