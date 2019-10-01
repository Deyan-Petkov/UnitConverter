package uk.ac.city.aczc791.UnitConverter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczc791.UnitConverter.entites.LoginHistory;

/**
 * Class to access the database table backing the LoginHistory entities.
 */
@Repository
public interface HistoryRepository extends JpaRepository<LoginHistory, String> {

}
