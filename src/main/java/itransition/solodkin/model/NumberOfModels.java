package itransition.solodkin.model;

/**
 * Created by eabil on 21.04.2017.
 */
public enum NumberOfModels {
    SINGLE("Single"),
    PAIRED("Paired"),
    GROUP("Group");

    private String type;

    NumberOfModels(String type) {
        this.type = type;
    }
}
