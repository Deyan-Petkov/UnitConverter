package uk.ac.city.aczc791.UnitConverter.entites;

import java.util.List;

/**
 * An Entity class representing all of the information relevant to a specific converterUser including
 * their saved conversions and login history.
 *
 * */
public class CollatedUser {

    private ConverterUser converterUser;
    private List<LoginHistory> logins;
    private List<SavedConversions> savedConversionsList;

    public CollatedUser(){}

    public ConverterUser getConverterUser() {
        return converterUser;
    }

    public void setConverterUser(ConverterUser converterUser) {
        this.converterUser = converterUser;
    }

    public List<LoginHistory> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginHistory> logins) {
        this.logins = logins;
    }

    public List<SavedConversions> getSavedConversionsList() {
        return savedConversionsList;
    }

    public void setSavedConversionsList(List<SavedConversions> savedConversionsList) {
        this.savedConversionsList = savedConversionsList;
    }

}
