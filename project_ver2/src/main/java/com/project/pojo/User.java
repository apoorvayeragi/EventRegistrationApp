package com.project.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usertable")
@PrimaryKeyJoinColumn (name="personId")
public class User extends Person implements Serializable{

	@Column (name="password")
    private String password;
	
	@Column (name="userName")
    private String userName;
	
	@Column (name="role")
	private String role;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<Event_Volunteer> vol_event_records = new HashSet<Event_Volunteer>();	
	
	@Column (name="status")
	//@Transient
	private String status;
	
	public User() {
		
    }

	
	public User(String firstName, String lastName, String email, String phone, String gender, String userName, String password, String role, String status){
	//	super(firstName, lastName, email, phone, birthDate, gender);
		this.userName = userName;
        this.password = password;
		this.role = role;
		this.status = status;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Event_Volunteer> getVol_event_records() {
		return vol_event_records;
	}

	public void setVol_event_records(Set<Event_Volunteer> vol_event_records) {
		this.vol_event_records = vol_event_records;
	}


	@Override
	public String toString() {
		return "User [password=" + password + ", userName=" + userName + ", role=" + role + "]";
	}
	
	
}
