package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dao.EventDAO;
import com.project.dao.UserDAO;
import com.project.exception.AdException;
import com.project.pojo.Event;
import com.project.pojo.User;

@Controller
public class AddEventController {
	
	@Autowired
	@Qualifier("eventValidator")
	EventValidator validator;

	@Autowired
	EventDAO eventDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/eventAdded.htm")
	protected String doAddEvent(@ModelAttribute("event") Event event, BindingResult result,HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("inside doAddEvent");
		validator.validate(event, result);
		if (result.hasErrors()) {
			return "AddNewEvents";
		}

		//Collection<User> evHeadList = UserDAO.getevHeadList();
		List<User> evHeadList = userDAO.getevHeadList();
		request.setAttribute("evHeadList", evHeadList);
		
		System.out.print("test");

		System.out.print("test1");
		Event myNewEvent  = event;
		//System.out.println(myNewEvent);
		eventDAO.saveEvent(myNewEvent);
		
		//eventDao.create(//eventName, eventHead, eventType, eventDesc, eventImagePath, addressId, streetName, city, state, country, zipCode);
		//eventDao.create(event.getEventId(), event.getEventName(), event.getEventHeadName(), event.getEventType(), event.getEventDesc(),event.getEventImagePath(), event.getAddress().getAddressId(), event.getAddress().getStreetName(), event.getAddress().getCity(), event.getAddress().getState(), event.getAddress().getCountry(), event.getAddress().getZipCode());

		return "EventAdded";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/AddNewEvents.htm")
	public String initializeForm(@ModelAttribute("event") Event event, BindingResult result, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, AdException {
		HttpSession session = request.getSession();
		List<User> evHeadList = userDAO.getevHeadList();
		request.setAttribute("evHeadList", evHeadList);
		//session.invalidate();
		return "AddNewEvents";
	}
}
