package itransition.solodkin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    private String avatar;

    @NotEmpty
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

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<FilmingType> filmingTypes;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<NumberOfModels> numberOfModels;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID")
    private List<CloudPhoto> cloudPhoto;

    public Profile(String nickname) {
        this.nickname = nickname;
    }
}
