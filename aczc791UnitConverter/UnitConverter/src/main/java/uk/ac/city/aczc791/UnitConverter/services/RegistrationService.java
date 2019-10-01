package uk.ac.city.aczc791.UnitConverter.services;


import uk.ac.city.aczc791.UnitConverter.entites.ConverterUser;

public interface RegistrationService {

    /**
     * Registration service interface that specifies a method to save user information to the database.
     */
    void registerUser(ConverterUser converterUser);
}
