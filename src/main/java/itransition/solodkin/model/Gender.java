package itransition.solodkin.model;

import lombok.Getter;

/**
 * Created by Влад on 11.04.2017.
 */
@Getter
public enum Gender {
    MAN("Man"),
    WOMAN("Woman"),
    BI_GENDERED("Bi-gendered"),
    CROSS_DRESSER("Cross-gendered"),
    FEMALE_TO_MALE("Female-to-Male"),
    MALE_TO_FEMALE("Male-to-Female"),
    TRANSSEXUAL("Transsexual"),
    DRAG_KING("Drag King"),
    DRAG_QUEEN("Drag Queen"),
    GENDER_BENDER("Gender Bender"),
    GENDER_QUEER("Gender Queer");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
