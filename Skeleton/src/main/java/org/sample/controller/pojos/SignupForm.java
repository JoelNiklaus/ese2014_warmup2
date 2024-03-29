package org.sample.controller.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.sample.model.Team;

public class SignupForm {


    private Long id;
    private String firstName;
    private String lastName;


    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", 
    message = "Must be valid email address")
    private String email;
    
    //private Long teamId;
    //private String teamName;
    
    private Team team;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
//
//	public Long getTeamId() {
//		return teamId;
//	}
//
//	public void setTeamId(Long teamId) {
//		this.teamId = teamId;
//	}
//
//	public String getTeamName() {
//		return teamName;
//	}
//
//	public void setTeamName(String teamName) {
//		this.teamName = teamName;
//	}

    
}
