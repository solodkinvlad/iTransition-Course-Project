package itransition.solodkin.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by eabil on 28.04.2017.
 */
@Getter
@Setter
public class ProfileSearch {
    private Set<Gender> genders;

    private Set<FilmingType> filmingTypes;

    private Set<NumberOfModels> numberOfModels;
}
