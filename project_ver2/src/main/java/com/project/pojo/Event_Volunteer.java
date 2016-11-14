package com.project.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="event_volunteer")
public class Event_Volunteer implements Serializable{

	@Id
	@GeneratedValue
	@Column (name="evId", unique=true, nullable=false)
    private long evId;
	
	@ManyToOne
	@JoinColumn(name="eventId")
	private Event event;

	@ManyToOne
	@JoinColumn(name="personId")
	private User user;
	
	@Column (name="requestStatus")
	private String status;
	
	public Event_Volunteer(){
		
	}	

	public Event_Volunteer(Event event,User user, String status){
		this.event = event;
	//	this.user = user;
		this.status = status;
	}
	
	public long getEvId() {
		return evId;
	}
	public void setEvId(long evId) {
		this.evId = evId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
