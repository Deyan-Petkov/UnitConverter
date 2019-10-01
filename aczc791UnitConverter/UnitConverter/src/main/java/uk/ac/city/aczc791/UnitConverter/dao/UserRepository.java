package uk.ac.city.aczc791.UnitConverter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.city.aczc791.UnitConverter.entites.ConverterUser;

/**
 * Class to access the database table backing the ConverterUser entity.
 */
@Repository
public interface UserRepository extends JpaRepository<ConverterUser, String> {


}
