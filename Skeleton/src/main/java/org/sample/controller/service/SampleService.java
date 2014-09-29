package org.sample.controller.service;

import java.util.HashMap;
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.NewTeamForm;
import org.sample.controller.pojos.Profile;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Team;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;
    
    public NewTeamForm saveFrom(NewTeamForm newTeamForm);

	public Profile getProfile(Long id);
	
	public Iterable<Team> getTeams();

}
