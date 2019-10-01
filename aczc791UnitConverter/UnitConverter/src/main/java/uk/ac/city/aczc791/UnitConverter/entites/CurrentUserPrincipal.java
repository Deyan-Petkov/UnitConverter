package uk.ac.city.aczc791.UnitConverter.entites;


import java.nio.file.attribute.UserPrincipal;

/**
 * An ConverterUserPrincipal represents the current user in the user details service.
 */
public class CurrentUserPrincipal implements UserPrincipal {

    private ConverterUser converterUser;

    public CurrentUserPrincipal(ConverterUser converterUser){
        this.converterUser = converterUser;
    }


    @Override
    public String getName() {
        return converterUser.getEmail();
    }

}
