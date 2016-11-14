package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.EventDAO;
import com.project.dao.UserDAO;
import com.project.exception.AdException;
import com.project.pojo.Event;
import com.project.pojo.Event_Volunteer;
import com.project.pojo.Person;
import com.project.pojo.User;

@Controller
public class ManageVolunteerRequestController {
	
	@Autowired
	UserDAO userDAO;
	private User user;
	private String username;
	//private Event event;
	
	@Autowired
	EventDAO eventDAO;
	

	@RequestMapping(value="/ManageVolunteerRequest.htm", method=RequestMethod.GET)
	public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, AdException {
		
		//String username = request.getParameter("username");

		System.out.println("Inside manage volunteer request page");
        HttpSession session = request.getSession();//
        username = (String) session.getAttribute("username");
        //session.setAttribute("username", username);
        System.out.println(username);
        //request.setAttribute("event", eventDAO.getEventsUnderHead(username));
        
        Long eventId = Long.parseLong((request.getParameter("eventId")));
        session.setAttribute("eventId", eventId);
        Long personId = userDAO.getPersonIdFromUserName(username);
        System.out.println("eventId"+eventId);
        System.out.println("personId"+personId);
        //request.setAttribute("volList", userDAO.getEventVolunteerRequest(eventId));
        List<User> userList = userDAO.getEventVolunteerRequest(eventId);
        ModelAndView mv = new ModelAndView("ManageVolunteerRequest");
        if(null == userList || userList.size()==0)
        {
        	mv.addObject("errorMessage","No volunteer found");
        }
        else
        {
        	mv.addObject("volList",userList);
        	}       
        
				return mv;		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/volAccept.htm")
	public ModelAndView volAccept(HttpServletRequest request, HttpServletResponse res) throws AdException {
        
		HttpSession session = request.getSession();
		System.out.println("reached volAccept");
		String username = request.getParameter("username");
		Long personId = userDAO.getPersonIdFromUserName(username);
		
		User user = userDAO.getUserDetails(personId);
		System.out.println(" usernamae is --- " +username);
		
		Long eventId = Long.parseLong((request.getParameter("eventId")));
		Event event = eventDAO.getEventDetails(eventId);
		
		userDAO.updateEventVolStatus(user, event, "Accepted");		
		
		List<User> userList = userDAO.getEventVolunteerRequest(eventId);
        ModelAndView mv = new ModelAndView("ManageVolunteerRequest");
        if(null == userList || userList.size()==0)
        {
        	mv.addObject("errorMessage","No volunteer found");
        }
        else
        {
        	mv.addObject("volList",userList);
        	}       
        
				return mv;	
}
	
//	@RequestMapping(method = RequestMethod.GET, value="/volReject.htm")
//	public ModelAndView volReject(HttpServletRequest request, HttpServletResponse res) throws AdException {
//        
//		HttpSession session = request.getSession();
//		System.out.println("reached volReject");
//		String username = request.getParameter("username");
//		Long personId = userDAO.getPersonIdFromUserName(username);
//		
//		User user = userDAO.getUserDetails(personId);
//		System.out.println(" usernamae is --- " +username);
//		
//		Long eventId = Long.parseLong((request.getParameter("eventId")));
//		Event event = eventDAO.getEventDetails(eventId);
//		
//		userDAO.updateEventVolStatus(user, event, "Rejected");		
//		
//		List<User> userList = userDAO.getEventVolunteerRequest(eventId);
//        ModelAndView mv = new ModelAndView("ManageVolunteerRequest");
//        if(null == userList || userList.size()==0)
//        {
//        	mv.addObject("errorMessage","No volunteer found");
//        }
//        else
//        {
//        	mv.addObject("volList",userList);
//        	}       
//        
//				return mv;	
//}
	

}
