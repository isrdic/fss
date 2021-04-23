package rs.srdic.fss.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.srdic.fss.model.enumeration.RoleEnum;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "korisnik")
@Entity
public class Korisnik {

    @Id
    @GeneratedValue
    private Integer userID;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, unique = true)
    @NotNull
    private RoleEnum roleName;
}