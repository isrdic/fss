package rs.srdic.fss.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.srdic.fss.model.enumeration.Pozicija;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "igrac")
@Getter
@Setter
@NoArgsConstructor
public class Igrac {

    @Id
    @GeneratedValue
    private Integer igracID;

    private String jmbg;

    private String ime;
    private String prezime;

    private Date datumRodjenja;

//    @Lob
//    private Byte[] slika;

    @Enumerated(EnumType.STRING)
    private Pozicija pozicija;

    @ManyToOne(targetEntity = Mesto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "mesto_id")
    private Mesto mesto;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "igrac",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Nastup> nastupi = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Igrac)) return false;
        Igrac that = (Igrac) o;
        return Objects.equals(jmbg, that.jmbg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmbg);
    }
}