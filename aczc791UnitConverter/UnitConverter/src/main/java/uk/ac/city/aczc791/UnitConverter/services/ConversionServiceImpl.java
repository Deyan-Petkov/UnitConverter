package uk.ac.city.aczc791.UnitConverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczc791.UnitConverter.dao.ConversionsRepo;
import uk.ac.city.aczc791.UnitConverter.entites.SavedConversions;
/**
 * Class implementing the methods specified in ConversionsService
 */
@Service
public class ConversionServiceImpl implements ConversionsService {

    /**
     * The ConversionsRepository for interacting with the database table backing the
     * SavedConversions entity.
     */
    private ConversionsRepo conversionsRepo;

    /**
     * Constructor based dependency injection of the conversions repository.
     * @param conversionsRepo
     */
    @Autowired
    ConversionServiceImpl(ConversionsRepo conversionsRepo){
        this.conversionsRepo = conversionsRepo;
    }

    /**
     * Implemented method using the conversionsRepo to save the conversions data.
     * @param savedConversions Conversions object which contains the conversion data.
     */
    @Override
    public void saveConversion(SavedConversions savedConversions) {
    conversionsRepo.save(savedConversions);
    }
}
