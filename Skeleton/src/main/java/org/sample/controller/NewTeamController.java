package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.NewTeamForm;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewTeamController {

    @Autowired
    SampleService sampleService;


    @RequestMapping(value = "/new-team", method = RequestMethod.GET)
    public ModelAndView newTeam() {
    	ModelAndView model = new ModelAndView("new-team");
    	model.addObject("newTeamForm", new NewTeamForm());    	
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@Valid NewTeamForm newTeamForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;    	
    	if (!result.hasErrors()) {
            try {
            	sampleService.saveFrom(newTeamForm);
            	model = new ModelAndView("show");
            } catch (InvalidUserException e) {
            	model = new ModelAndView("new-team");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	model = new ModelAndView("new-team");
        }   	
    	return model;
    }

}


