package com.project.pojo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="eventheadtable")
@PrimaryKeyJoinColumn (name="personId")
public class EventHead extends User implements Serializable{
	

	
	@OneToMany(mappedBy="eventHead")
	private Collection<Event> eventList = new ArrayList<Event>();
	
	@Column (name="headRequestStatus")
	private String headRequestStatus;

	public EventHead() {
    }
	
	public EventHead(String userName, String password, Collection<Event> eventList, String headRequestStatus) {
		//super(userName, password);
		this.eventList = eventList;
		this.headRequestStatus = headRequestStatus;
	}

	public String getHeadRequestStatus() {
		return headRequestStatus;
	}

	public void setHeadRequestStatus(String headRequestStatus) {
		this.headRequestStatus = headRequestStatus;
	}

	public Collection<Event> getEventList() {
		return eventList;
	}

	public void setEventList(Collection<Event> eventList) {
		this.eventList = eventList;
	}
	
	
}
