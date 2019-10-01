package uk.ac.city.aczc791.UnitConverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczc791.UnitConverter.entites.ConverterUser;
import uk.ac.city.aczc791.UnitConverter.services.ProfileService;

@Controller
public class UnitConverterController {

    /**
     * Controller method to handle a GET request to the /index endpoint
     * @return ModelAndView returns a view constructed from index.html (no model required)
     */
    @RequestMapping(value="/index")
    public ModelAndView showHome(){
        return new ModelAndView("index");
    }

    /**
     * Controller method to handle a GET request to the /information.html endpoint
     * @return ModelAndView returns a view constructed from information.html (no model required)
     */
    @RequestMapping(value= "/information.html")
    public ModelAndView showInformation(){
        return new ModelAndView("information");
    }



}
