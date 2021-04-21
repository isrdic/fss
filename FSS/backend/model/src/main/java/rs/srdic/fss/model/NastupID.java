package rs.srdic.fss.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class NastupID implements Serializable {

    @Column(name = "igracID")
    private Integer igracID;

    @Column(name = "utakmicaID")
    private Integer utakmicaID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || (o instanceof NastupID)) return false;

        NastupID that = (NastupID) o;
        return Objects.equals(igracID, that.igracID) &&
                Objects.equals(utakmicaID, that.utakmicaID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(igracID, utakmicaID);
    }
}
