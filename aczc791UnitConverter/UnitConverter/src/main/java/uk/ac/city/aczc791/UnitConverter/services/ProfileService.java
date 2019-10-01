package uk.ac.city.aczc791.UnitConverter.services;


import uk.ac.city.aczc791.UnitConverter.entites.CollatedUser;

/**
 * Profile service interface that specifies a method to return a CollatedUser.
 */
public interface ProfileService {

    CollatedUser getProfile(String email);
}
