package com.project.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="addresstable")
public class Address implements Serializable{
	
	@Id
	@GeneratedValue
	@Column (name="addressId", unique=true, nullable=false)
    private long addressId;
	
	@Column (name="streetName")
    private String streetName;
	
	@Column (name="city")
    private String city;
	
	@Column (name="state")
    private String state;
	
	@Column (name="country")
    private String country;
	
	@Column (name="zipCode")
    private String zipCode;
	
	@OneToMany(mappedBy="address")
	private Collection<Event> eventList = new ArrayList<Event>();
	
	@OneToMany(mappedBy ="address")
	private Collection<Person> personList = new ArrayList<Person>();
	
	
	Address(Long addressId, String streetName, String city, String state, String country, String zipCode){
		this.addressId = addressId;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	public Address(){
		
	}
	
	public Collection<Event> getEventList() {
		return eventList;
	}


	public void setEventList(Collection<Event> eventList) {
		this.eventList = eventList;
	}


	public Collection<Person> getPersonList() {
		return personList;
	}


	public void setPersonList(Collection<Person> personList) {
		this.personList = personList;
	}


	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}


	public Long getAddressId()  
    {  
        return addressId;  
    }  
    public void setAddressId(Long addressId)  
    {  
        this.addressId = addressId;  
    }
    
    public String getStreetName()  
    {  
        return streetName;  
    }  
    public void setStreetName(String streetName)  
    {  
        this.streetName = streetName;  
    }
    
    public String getCity()  
    {  
        return city;  
    }  
    public void setCity(String city)  
    {  
        this.city = city;  
    }
    
    public String getState()  
    {  
        return state;  
    }  
    public void setState(String state)  
    {  
        this.state = state;  
    }
    
    public String getCountry()  
    {  
        return country;  
    }  
    public void setCountry(String country)  
    {  
        this.country = country;  
    }
    
    public String getZipCode()  
    {  
        return zipCode;  
    }  
    public void setZipCode(String zipCode)  
    {  
        this.zipCode = zipCode;  
    }
     
}
