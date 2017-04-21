package itransition.solodkin.model;

/**
 * Created by eabil on 21.04.2017.
 */
public enum FilmingType {

    PORTRAIT("Portrait"),
    PORTRAIT_IN_THE_INTERIOR("Portrait in the interior"),
    BEAUTY("Beauty"),
    PIN_UP("Pin up"),
    FASHION("Fashion"),
    WET("Wet"),
    EROTICA("Erotica"),
    TRASH("Trash"),
    MILITARY("Military");

    private String type;

    FilmingType(String type) {
        this.type = type;
    }
}
