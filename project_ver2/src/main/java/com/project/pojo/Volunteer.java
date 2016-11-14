package com.project.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="volunteertable")
public class Volunteer  implements Serializable{
	
	@ManyToMany(mappedBy ="volunteerList")
	private Collection<Event> eventList = new ArrayList<Event>();
	@Id
	private long id;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<Event> getEventList() {
		return eventList;
	}

	public void setEventList(Collection<Event> eventList) {
		this.eventList = eventList;
	}

	Volunteer() {
    }

	public Volunteer(String userName, String password, Collection<Event> eventList) {
		//super(userName, password);
		this.eventList = eventList;
	}

}
