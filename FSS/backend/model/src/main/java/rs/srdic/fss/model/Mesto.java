package rs.srdic.fss.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MESTO")
@Entity
public class Mesto {

    @Id
    @GeneratedValue
    private Integer mestoID;

    private int ptt;
    private String naziv;

    @OneToMany(targetEntity = Klub.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mesto")
    private List<Klub> klubovi;

    @OneToMany(targetEntity = Igrac.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mesto")
    private List<Igrac> igraci;

    public void addKlub(Klub klub) {
        klubovi.add(klub);
        klub.setMesto(this);
    }

    public void removeKlub(Klub klub) {
        klubovi.remove(klub);
        klub.setMesto(null);
    }

    public void addIgrac(Igrac igrac) {
        igraci.add(igrac);
        igrac.setMesto(this);
    }

    public void removeIgrac(Igrac igrac) {
        igraci.remove(igrac);
        igrac.setMesto(null);
    }
}