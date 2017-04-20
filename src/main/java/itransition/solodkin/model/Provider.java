package itransition.solodkin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Влад on 20.04.2017.
 */
@Entity
@Table(name = "providers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Provider {
    @Id
    @Column(name = "PROVIDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long providedId;

    @NotNull
    private String provider;
}
