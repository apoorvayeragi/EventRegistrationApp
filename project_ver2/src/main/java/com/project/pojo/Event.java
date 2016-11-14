package com.project.pojo;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="eventtable")
public class Event implements Serializable{

	@Id
	@GeneratedValue
	@Column (name="eventId", unique=true, nullable=false)
    private long eventId;	
	
	@Column (name="eventName")
    private String eventName;
	
	@Column (name="eventHeadName")
    private String eventHeadName;
	
	@Column (name="eventType")
    private String eventType;
	
	@Column (name="eventDate")
    private String eventDate;
	
	@Column (name="eventDesc")
    private String eventDesc;
	
	@Transient
	private MultipartFile photo;
	
	@Column (name="eventImagePath")
    private String eventImagePath;
	

	
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;
	
//	@ManyToMany
//	private Collection<Volunteer> volunteerList = new ArrayList<Volunteer>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "event")
	private Set<Event_Volunteer> event_vol_records = new HashSet<Event_Volunteer>();
	
	public Event(){
		
	}
	
	public Event(Long eventId, String eventName, String eventHead, String eventType, String eventDate, String eventDesc, String eventImagePath){
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventHeadName = eventHeadName;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventDesc = eventDesc;
		this.eventImagePath = eventImagePath;
		//this.address =  address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public Long getEventId()  
    {  
        return eventId;  
    }  
    public void setEventId(Long eventId)  
    {  
        this.eventId = eventId;  
    }
    
    public String getEventName()  
    {  
        return eventName;  
    }  
    public void setEventName(String eventName)  
    {  
        this.eventName = eventName;  
    }
    
    public String getEventHeadName()  
    {  
        return eventHeadName;  
    }  
    public void setEventHeadName(String eventHeadName)  
    {  
        this.eventHeadName = eventHeadName;  
    }

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
    
	public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

	public String getEventImagePath() {
		return eventImagePath;
	}

	public void setEventImagePath(String eventImagePath) {
		this.eventImagePath = eventImagePath;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	public Set<Event_Volunteer> getEvent_vol_records() {
		return event_vol_records;
	}

	public void setEvent_vol_records(Set<Event_Volunteer> event_vol_records) {
		this.event_vol_records = event_vol_records;
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", eventType=" + eventType + ", eventDesc=" + eventDesc
				+ ", eventImagePath=" + eventImagePath + ", address=" + address 
				+ "]";
	}
    
}
