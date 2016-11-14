package com.project.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.dao.EventDAO;
import com.project.pojo.Event;
import com.project.pojo.User;


@Component
public class EventValidator implements Validator{

	public boolean supports(Class aClass)
    {
		 //TODO Auto-generated method stub
        return aClass.equals(Event.class);
    }
	
	public void validate(Object obj, Errors errors)
    {
		 //TODO Auto-generated method stub
		Event event = (Event) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventName", "error.invalid.event.eventName", "Event Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventHeadName", "error.invalid.event.eventHeadName", "EventHead Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventDate", "error.invalid.event.eventDate", "Event Date Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventType", "error.invalid.event.eventType", "Event Type Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventDesc", "error.invalid.event.eventDesc", "Event Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventImagePath", "error.invalid.event.eventImagePath", "Event ImagePath Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.streetName", "error.invalid.address.streetName", "Street Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "error.invalid.address.city", "City Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "error.invalid.address.state", "State Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.country", "error.invalid.address.country", "Country Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zipCode", "error.invalid.address.zipCode", "Zip Code Required");
    
        EventDAO eventDAO = new EventDAO();
        
        System.out.println("username: "+event.getEventHeadName());
        if(eventDAO.checkIfEventHeadAcepted(event.getEventHeadName())){
        	System.out.println("event head present");
        }
        else{
        	errors.rejectValue("eventHeadName", "error.invalid.event.eventHeadName", "Event Head is not yet registered");
        }
        
                
        System.out.println("eventDate: "+event.getEventDate());
        if(eventDAO.isDateValid(event.getEventDate())){
        	System.out.println("Valid date");
        }
        else{
        	errors.rejectValue("eventDate", "error.invalid.event.eventDate", "The date format should be in \"yyyy-MM-dd\" format");
        }
    
        event.setEventName(event.getEventName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim());
        event.setEventHeadName(event.getEventHeadName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim());
        event.setEventDesc(event.getEventDesc().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim());
        
     }
}
