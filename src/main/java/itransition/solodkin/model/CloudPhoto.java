package itransition.solodkin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cloudphotos")
@Getter
@Setter
@NoArgsConstructor
public class CloudPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

    @ElementCollection
    private Set<Long> userSet;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PHOTO_ID")
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="photos_tags", joinColumns = {@JoinColumn (name="photo_id")}, inverseJoinColumns = {@JoinColumn (name="tag_id")})
    private List<Tag> tags;
}
