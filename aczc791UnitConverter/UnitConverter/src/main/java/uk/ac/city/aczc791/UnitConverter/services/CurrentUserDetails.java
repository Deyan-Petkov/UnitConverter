package uk.ac.city.aczc791.UnitConverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.ac.city.aczc791.UnitConverter.dao.HistoryRepository;
import uk.ac.city.aczc791.UnitConverter.dao.UserRepository;
import uk.ac.city.aczc791.UnitConverter.entites.ConverterUser;
import uk.ac.city.aczc791.UnitConverter.entites.LoginHistory;


import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Custom authentication service which includes recording login history
 * each time a converterUser is authenticated.
 */
@Service
public class CurrentUserDetails implements UserDetailsService {


    /**
     * The repository for converterUser data.
     */
    private UserRepository userRepository;
    /**
     * The repository for login history
     */
    private HistoryRepository historyRepository;

    /**
     * Constructor based dependency injection of repositories.
     *
     * @param userRepository the converterUser repo
     * @param historyRepository the login history repo
     */
    @Autowired
    public CurrentUserDetails(UserRepository userRepository, HistoryRepository historyRepository){
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * The override fo the UserDetailsService method that validates a converterUser. The methods find the
     * converterUser in the database based on the String s provided by the users login credentials (their email
     * address)
     *
     * @param s converterUser's email address provided when logging in.
     * @return UserDetails an object representing the converterUser including their password, account status and roles
     * @throws UsernameNotFoundException if the converterUser cannot be found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ConverterUser converterUser = userRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("No matching converterUser."));
        //if the first line does not throw the exception the login history
        //object will be constructed and saved to the database.
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setEmail(converterUser.getEmail());
        loginHistory.setTime(LocalDateTime.now());
        historyRepository.save(loginHistory);
        //and a UserDetails object will be constructed and returned.
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(converterUser.getAuthority()));
        return new User(converterUser.getEmail(), converterUser.getPassword(), converterUser.getEnabled(),
                        true, true, true, authorities);


    }
}
