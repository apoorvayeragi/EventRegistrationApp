package com.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.EventDAO;
import com.project.dao.UserDAO;
import com.project.exception.AdException;
import com.project.pojo.Event;
import com.project.pojo.User;

@Controller
public class ManageEventRequestController {

	@Autowired
	UserDAO userDAO;
	private User user;
	
	@Autowired
	EventDAO eventDAO;
	
	
	//this will be written when there would be criteria to print event list that are not yrt requested by the voulunteers
	
	
	//to update intermediate table after clicking on request button 
	//Volunteer login page after clicking on request button
	
	
	@RequestMapping(value="/eventRequest.htm",method = RequestMethod.POST)
	
	public String processEventRequest(@RequestParam( value="event")long event
			,HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedUser");
		
		try {
			eventDAO.saveEventVol(user, event);
			//eventDAO.getRegisteredList(user);
			List<Event> eventList = eventDAO.getRegisteredList(user);
			
			session.setAttribute("event", eventList);
				
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "VolunteerHomePage";
	}
	
	// the ModelAndView request pattern
//	public ModelAndView requestEvent(@RequestParam( value="event")long event
//			,HttpServletRequest request,HttpServletResponse response) 
//	{
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("loggedUser");
//		
//		try {
//			eventDAO.saveEventVol(user, event);
//			//eventDAO.getRegisteredList(user);
//			List<Event> eventList = eventDAO.getRegisteredList(user);
//			List<Event> newEventList = new ArrayList<Event>();
//			Iterator eventIterator = eventList.iterator();
//			
//			while (eventIterator.hasNext())
//			{
//				Event newEvent = (Event) eventIterator.next();
//				newEventList.add(newEvent);
//			    
//			}
//			
//			ModelAndView mv = new ModelAndView("ManageHeadRequest","eventRequest", newEventList);
//			return mv;
//		} catch (AdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
	
}



