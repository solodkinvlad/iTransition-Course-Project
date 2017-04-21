package itransition.solodkin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Profile {

    @Id
    @Column(name = "PROFILE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotEmpty
    private String nickname;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    //@NotNull
    private double weight;

    //@NotNull
    private double height;

    //@NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;



    public Profile(String nickname) {
        this.nickname = nickname;
    }
}
