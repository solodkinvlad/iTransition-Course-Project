package itransition.solodkin.model;

/**
 * Created by Влад on 12.04.2017.
 */
public enum UserRole {
    ROLE_ADMIN("Admin"),
    ROLE_USER("User");

    private final String label;

    UserRole(String role) {
        this.label = role;
    }

    public String getLabel() {
        return label;
    }
}
