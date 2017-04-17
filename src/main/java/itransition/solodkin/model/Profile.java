package itransition.solodkin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    //@NotNull
    private double weight;

    //@NotNull
    private double height;

    //@NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Profile(String name) {
        this.name = name;
    }
}
