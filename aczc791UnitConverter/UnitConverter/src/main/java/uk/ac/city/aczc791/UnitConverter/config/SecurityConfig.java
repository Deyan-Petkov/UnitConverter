package uk.ac.city.aczc791.UnitConverter.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uk.ac.city.aczc791.UnitConverter.services.CurrentUserDetails;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Custom user details service that also records user login
     * history in the database.
     */
    private CurrentUserDetails currentUserDetails;

    /**
     * Constructor based dependency injection of custom user details service.
     *
     * @param currentUserDetails The current user.
     */
    @Autowired
    public SecurityConfig(CurrentUserDetails currentUserDetails) {
        this.currentUserDetails = currentUserDetails;
    }

    /**
     * Set the authentication service to use the custom user details service.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.
                authenticationProvider(authenticationProvider());

    }

    /**
     * Provide access to the profile only after user authenticates it self using his email and password
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/profile")
                .authenticated()
                .and()
                .formLogin();

        //disable security to database console
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    /**
     * Method to construct an authentication provided which uses the  custom user details
     * service so it can be supplied to the auth object (together with a BCrypt password
     * encoder. Method is called when configuring authentication.
     *
     * @return DaoAuthenticationProvider an authentication provider that contains the custom
     * user details service and password encoder.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(currentUserDetails);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

}
