package rs.srdic.fss.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KLUB")
@Entity
public class Klub {

    @Id
    @GeneratedValue
    private Integer klubID;

    private String naziv;

    @ManyToOne(targetEntity = Mesto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "mesto_id")
    private Mesto mesto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Klub)) return false;
        return klubID != null && klubID.equals(((Klub)o).getKlubID());
    }
    @Override
    public int hashCode() {
        return 31;
    }
}