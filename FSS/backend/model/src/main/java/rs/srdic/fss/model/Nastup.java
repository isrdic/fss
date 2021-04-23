package rs.srdic.fss.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "nastup")
@Entity
public class Nastup {

//    @Setter(AccessLevel.NONE)
//    @Getter(AccessLevel.NONE)
//    @Column(name = "ID", nullable = false)
//    @Id
//    @GeneratedValue
//    private Integer nastupID;

    @EmbeddedId
    private NastupID nastupID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("igracID")
    private Igrac igrac;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("utakmicaID")
    private Utakmica utakmica;

    private Double ocenaIgraca;

    public Nastup(Igrac igrac, Utakmica utakmica, Double ocenaIgraca) {
        this.igrac = igrac;
        this.utakmica = utakmica;
        this.nastupID = new NastupID(igrac.getIgracID(), utakmica.getUtakmicaID());
        this.ocenaIgraca = ocenaIgraca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || (o instanceof Nastup)) return false;

        Nastup that = (Nastup) o;
        return Objects.equals(igrac, that.igrac) &&
                Objects.equals(utakmica, that.utakmica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(igrac, utakmica);
    }

}