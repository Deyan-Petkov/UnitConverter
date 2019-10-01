package uk.ac.city.aczc791.UnitConverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczc791.UnitConverter.entites.SavedConversions;
import uk.ac.city.aczc791.UnitConverter.services.ConversionsService;

@Controller
public class ConversionsController {
    /**
     * The service which saves saved user conversions to
     * the database
     */
    ConversionsService conversionsService;

    /**
     * Constructor based dependency injection for the  conversions service
     * @param conversionsService
     */
    @Autowired
    ConversionsController(ConversionsService conversionsService){
        this.conversionsService = conversionsService;
    }

    /**
     * Controller method to handle a Get request to the /weight endpoint
     * @return ModelAndView object that combines the weight.html page with a SavedConversions
     * object which can be filled out with conversions data to be saved in the database.
     */
    @RequestMapping(value = "/weight", method = RequestMethod.GET)
    public ModelAndView getWeight(){
        SavedConversions savedConversions = new SavedConversions();
        return new ModelAndView("weight", "savedConversions", savedConversions);
    }

    /**
     * Controller method to handle a post request to the /weight endpoint
     * @param savedConversions the object that contains information which is going to be saved in the database.
     * @return String which redirect to the profile page.
     */
    @RequestMapping (value = "/weight", method = RequestMethod.POST)
    public String saveWeight(SavedConversions savedConversions){
        //Retrieves the email address of the currently logged in user.
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        savedConversions.setEmail(email);
        conversionsService.saveConversion(savedConversions);
        return "redirect:/profile";
    }

    /**
     * Controller method to handle a get request to the /liquid endpoint
     * @return ModelAndView object that combines the liquid.html page with a SavedConversions
     * object which can be filled out with conversions data to be saved in the database.
     *
     */
    @RequestMapping(value = "/liquid", method = RequestMethod.GET)
    public ModelAndView getLiquid(){
        SavedConversions savedConversions = new SavedConversions();
        return new ModelAndView("liquid","savedConversions",savedConversions);
    }

    /**
     * Controller method to handle a post request to the /liquid endpoint.
     * @param savedConversions the object that contains information which is going to be saved in the database.
     * @return String a redirect to the profile page.
     */
    @RequestMapping(value = "/liquid", method = RequestMethod.POST)
    public String saveLiquid(SavedConversions savedConversions){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        savedConversions.setEmail(email);
        conversionsService.saveConversion(savedConversions);
        return "redirect:/profile";
    }
    /**
     * Controller method to handle a get request to the /distance endpoint
     * @return ModelAndView object that combines the distance.html page with a SavedConversions
     * object which can be filled out with conversions data to be saved in the database.
     *
     */
    @RequestMapping(value = "/distance",method = RequestMethod.GET)
    public ModelAndView getDistance(){
        SavedConversions savedConversions = new SavedConversions();
        return new ModelAndView("distance","savedConversions",savedConversions);
    }
    /**
     * Controller method to handle a post request to the /distance endpoint.
     * @param savedConversions the object that contains information which is going to be saved in the database.
     * @return String a redirect to the profile page.
     */
    @RequestMapping(value = "/distance",method = RequestMethod.POST)
    public String saveDistance(SavedConversions savedConversions){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        savedConversions.setEmail(email);
        conversionsService.saveConversion(savedConversions);
        return "redirect:/profile";
    }
}
