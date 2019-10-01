package uk.ac.city.aczc791.UnitConverter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczc791.UnitConverter.entites.SavedConversions;

/**
 * Class to access the database table backing the SavedConversions entity.
 */
@Repository
public interface ConversionsRepo extends JpaRepository<SavedConversions, String> {

}
