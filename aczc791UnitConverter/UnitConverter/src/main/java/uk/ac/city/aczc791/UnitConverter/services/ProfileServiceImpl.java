package uk.ac.city.aczc791.UnitConverter.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.aczc791.UnitConverter.dao.ConversionsRepo;
import uk.ac.city.aczc791.UnitConverter.dao.HistoryRepository;
import uk.ac.city.aczc791.UnitConverter.dao.UserRepository;
import uk.ac.city.aczc791.UnitConverter.entites.CollatedUser;
import uk.ac.city.aczc791.UnitConverter.entites.LoginHistory;
import uk.ac.city.aczc791.UnitConverter.entites.SavedConversions;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    /**
     * The repository for conversions data.
     */

    private ConversionsRepo conversionsRepo;
    /**
     * The repository for converter user data.
     */
    private UserRepository userRepository;

    /**
     * The repository for login history.
     */
    private HistoryRepository historyRepository;


    /**
     *
     * Constructor based dependency injection of repositories.
     *
     * @param historyRepository the login history repo
     */
    @Autowired
    public ProfileServiceImpl(UserRepository userRepository, ConversionsRepo conversionsRepo,
                              HistoryRepository historyRepository){
        this.conversionsRepo = conversionsRepo;
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }


     /**
     * The implemented method that collates all the current users information
     * into a single object that will back the profile.html view
     *
     * @param email the current user's email
     * @return CollatedUser a object that aggregates all the user's data.
     */
    @Override
    public CollatedUser getProfile(String email) {
        CollatedUser user = new CollatedUser();
        user.setConverterUser(userRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("No matching user found.")));

        List<SavedConversions>savedConversions = conversionsRepo.findAll()
                .stream().filter(savedConvertion -> savedConvertion.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setSavedConversionsList(savedConversions);


        List<LoginHistory> history = historyRepository.findAll()
                .stream().filter(loginHistory -> loginHistory.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setLogins(history);
        return user;
    }
}
