package uk.ac.city.aczc791.UnitConverter.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * An Entity class representing the information required for a given user to save conversion.
 */
@Entity
public class SavedConversions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long key;
    private String email;
    private String conversions;

    public SavedConversions() {}

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConversions() {
        return conversions;
    }

    public void setConversions(String conversions) {
        this.conversions = conversions;
    }
}
