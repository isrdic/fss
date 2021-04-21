package rs.srdic.fss.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "UTAKMICA")
@Entity
public class Utakmica {

    @Id
    @GeneratedValue
    private Integer utakmicaID;

    private Date datumOdigravanja;

    @ManyToOne(targetEntity = Klub.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "domacin_id")
    private Klub domacin;

    @ManyToOne(targetEntity = Klub.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "gost_id")
    private Klub gost;

    @ManyToOne(targetEntity = Takmicenje.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "takmicenje_id")
    private Takmicenje takmicenje;

    @OneToMany(
            mappedBy = "utakmica",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Nastup> nastupi = new ArrayList<>();

    public void dodajIgraca(Igrac igrac) {
        Nastup nastup = new Nastup(igrac, this);
        nastupi.add(nastup);
        igrac.getNastupi().add(nastup);
    }

    public void izbaciIgraca(Igrac igrac) {
        for (Iterator<Nastup> iterator = nastupi.iterator();
             iterator.hasNext(); ) {
            Nastup nastup = iterator.next();
            if (nastup.getUtakmica().equals(this) && nastup.getIgrac().equals(igrac)) {
                iterator.remove();
                nastup.getIgrac().getNastupi().remove(nastup);
                nastup.setIgrac(null);
                nastup.setUtakmica(null);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Utakmica)) return false;

        Utakmica that = (Utakmica) o;
        return Objects.equals(utakmicaID, that.getUtakmicaID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(utakmicaID);
    }
}