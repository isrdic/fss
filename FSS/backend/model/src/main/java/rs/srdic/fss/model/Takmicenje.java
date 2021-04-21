package rs.srdic.fss.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "TAKMICENJE")
@Entity
public class Takmicenje {

    @Id
    @GeneratedValue
    private Integer takmicenjeID;

    private String nazivTakmicenja;

    @OneToMany(targetEntity = Utakmica.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "takmicenje")
    private List<Utakmica> utakmice;

    public void addUtakmica(Utakmica utakmica) {
        utakmice.add(utakmica);
        utakmica.setTakmicenje(this);
    }

    public void removeUtakmica(Utakmica utakmica) {
        utakmice.remove(utakmica);
        utakmica.setTakmicenje(null);
    }
}