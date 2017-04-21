package itransition.solodkin.model;

import lombok.Getter;

/**
 * Created by eabil on 21.04.2017.
 */
@Getter
public enum NumberOfModels {
    SINGLE("Single"),
    PAIRED("Paired"),
    GROUP("Group");

    private String type;

    NumberOfModels(String type) {
        this.type = type;
    }
}
