package uk.ac.city.aczc791.UnitConverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczc791.UnitConverter.entites.ConverterUser;
import uk.ac.city.aczc791.UnitConverter.services.RegistrationService;


@Controller
public class RegistrationController {

    /**
     * The registration service which is used to save user information to the
     * database.
     */
    private RegistrationService registrationService;
    /**
     * Constructor based dependency injection of the registration service
     *
     * @param registrationService
     */
    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    /**
     * Controller method for responding to a GET request to the /register endpoint
     *
     * @return ModelAndView a view created from register.html backed by an ConverterUser object
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm() {
        ConverterUser converterUser = new ConverterUser();
        return new ModelAndView("register", "converterUser", converterUser);
    }
    /**
     * Controller method to handle a POST request to the /register endpoint
     *
     * @param converterUser an object containing the data from the registration form
     * @return String a redirect to the profile page (which requires the user to login)
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(ConverterUser converterUser) {
        converterUser.setEnabled(Boolean.TRUE);
        converterUser.setAuthority("ROLE_USER");
        registrationService.registerUser(converterUser);
        return "redirect:/profile";
    }

}
