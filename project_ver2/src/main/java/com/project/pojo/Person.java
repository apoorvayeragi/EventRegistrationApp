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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="persontable")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person implements Serializable{

	@Id
	@GeneratedValue
	@Column (name="personId", unique=true, nullable=false)
    private long personId;

	@Column (name="firstName")
	private String firstName;
	
	@Column (name="lastName")
	private String lastName;
	
	@Column (name="email")
	private String email;

	@Column (name="phone")
	private String phone;


	@Column (name="gender")
	private String gender;

	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;

//	@ManyToMany
//	private Collection<Address> addressList = new ArrayList<Address>();
	
	public Person(){
		
	}
	
	public Person(String firstName, String lastName, String email, String phone, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}
	
	
//	public Collection<Address> getAddressList() {
//		return addressList;
//	}
//
//	public void setAddressList(Collection<Address> addressList) {
//		this.addressList = addressList;
//	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public Long getPersonId()  
    {  
        return personId;  
    }  
    
    public String getFirstName()  
    {  
        return firstName;  
    }  
    public void setFirstName(String firstName)  
    {  
        this.firstName = firstName;  
    }
    
    public String getLastName()  
    {  
        return lastName;  
    }  
    public void setLastName(String lastName)  
    {  
        this.lastName = lastName;  
    }
    
    public String getPhone()  
    {  
        return phone;  
    }  
    public void setPhone(String phone)  
    {  
        this.phone = phone;  
    }
    
    public String getEmail()  
    {  
        return email;  
    }  
    public void setEmail(String email)  
    {  
        this.email = email;  
    }
    
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    
 
}
