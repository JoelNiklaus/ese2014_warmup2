package org.sample.controller.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.NewTeamForm;
import org.sample.controller.pojos.Profile;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Address;
import org.sample.model.Team;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    @Autowired    TeamDao teamDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }


        Address address = new Address();
        address.setStreet("TestStreet-foo");
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        Team team = teamDao.findOne(signupForm.getTeam().getId());
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        user.setTeam(team);
        
        user = userDao.save(user);   // save object to DB
          
        signupForm.setId(user.getId());

        return signupForm;

    }

    @Transactional
	public NewTeamForm saveFrom(NewTeamForm newTeamForm) {
		String name = newTeamForm.getName();
		Date date = newTeamForm.getDate();
		
		Team team = new Team();
		team.setName(name);
		team.setDate(date);
		
		team = teamDao.save(team);
		
		newTeamForm.setId(team.getId());
		
		return newTeamForm;
	}

	public Profile getProfile(Long id) {
		Iterable<User> users = userDao.findAll();  // find all 
		User user = userDao.findOne(id); // find by ID
		
		Profile profile = new Profile();
		profile.setId(user.getId());
		profile.setFirstName(user.getFirstName());
		profile.setLastName(user.getLastName());
		profile.setEmail(user.getEmail());
		profile.setTeamName(user.getTeam().getName());
		
		return profile;
	}

	public Iterable<Team> getTeams() {
		Iterable<Team> teams = teamDao.findAll();  // find all
		return teams;
	}
}
