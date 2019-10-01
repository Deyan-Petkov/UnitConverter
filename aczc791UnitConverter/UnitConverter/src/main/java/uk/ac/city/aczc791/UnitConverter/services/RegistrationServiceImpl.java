package uk.ac.city.aczc791.UnitConverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.city.aczc791.UnitConverter.dao.UserRepository;
import uk.ac.city.aczc791.UnitConverter.entites.ConverterUser;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    /**
     * The repository for converter user data.
     */
    private UserRepository userRepository;

    /**
     * Constructor based dependency injection
     * @param userRepository The ConverterUser repository
     */
    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     *Saves converter user to the database.
     * @param converterUser The converter user which is going ot be saved.
     */
    @Override
    public void registerUser(ConverterUser converterUser) {
        userRepository.save(converterUser);
    }


}
