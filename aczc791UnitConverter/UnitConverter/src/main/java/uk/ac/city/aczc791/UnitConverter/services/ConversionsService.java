package uk.ac.city.aczc791.UnitConverter.services;

import uk.ac.city.aczc791.UnitConverter.entites.SavedConversions;

public interface ConversionsService {
    /**
     * A service interface containing methods used by the controllers
     * to record and retrieve conversions information.
     */
    void saveConversion(SavedConversions savedConversions);
}
