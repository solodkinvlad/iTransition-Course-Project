package itransition.solodkin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by eabil on 24.04.2017.
 */

@Entity
@Table(name = "cloudphotos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CloudPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

    @ElementCollection
    private Set<Long> userSet;

}
