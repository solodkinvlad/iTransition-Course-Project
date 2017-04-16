package itransition.solodkin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String name;

    private Date birthday;
    private double weight;
    private double height;
    private Gender gender;

    public User(String name) {
        this.name = name;
    }

    public User(String name, UserRole userRole, String password, String email) {
        this.name = name;
        this.userRole = userRole;
        this.password = password;
        this.email = email;
    }
}
