package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dao.EventDAO;
import com.project.dao.UserDAO;
import com.project.exception.AdException;
import com.project.pojo.Event;
import com.project.pojo.User;

@Controller
public class VerifyUserLoginController {

	@Autowired
	UserDAO userDAO;
	private User user;
	
	@Autowired
	EventDAO eventDAO;
	
	@RequestMapping(value="/verifyLogin.htm", method=RequestMethod.POST)
	public String processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, AdException {
        System.out.println("in the 2ndlogin");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
 
        user = userDAO.authenticateUser(username, password, role);
          HttpSession session = request.getSession();
//        session.setAttribute("username", username);
//        session.setAttribute("event", eventDAO.getEventsUnderHead(username));
        
        System.out.println(username);
        System.out.println(password);
        System.out.println(role);
        System.out.println(user);
       
        if(user==null){
        	request.setAttribute("error", "Invalid username and password");
        	return "LoginForm";
        }
        if(role.equals("Volunteer")){ 	
        	
        	System.out.println("insidevoulunterr");
            //user = userDAO.authenticateUser(username, password, role);
        	session.setAttribute("loggedUser", user);
            session.setAttribute("username", username);
            List<Event> eventList = eventDAO.getRegisteredList(user);
            session.setAttribute("event", eventList);
//            session.setAttribute("event", eventDAO.list());
//            List<Event> eventList = eventDAO.list();
//            for(Event ev : eventList){
//            	System.out.println(ev.getEventName());
//            }
            
            
            System.out.println(username);
            System.out.println(password);
            System.out.println(role);
        	
        	return "VolunteerHomePage";
        }
        else if(role.equals("EventHead")){
            //user = userDAO.authenticateUser(username, password, role);
            session.setAttribute("username", username);
            
            session.setAttribute("event", eventDAO.getEventsUnderHead(username));
            List<Event> eventList = eventDAO.getEventsUnderHead(username);
            for(Event ev : eventList){
            	System.out.println(ev.getEventName());
            }
            System.out.println(username);
            System.out.println(password);
            System.out.println(role);
        	
        	System.out.println("insideeventhead");
        	return "EventHeadHomePage";
        }
        System.out.println("will return home page");
        return null;
	}
	
	@RequestMapping(value="/EventHeadHomePage.htm", method=RequestMethod.GET)
	public String processHeadHomePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, AdException {
		
        HttpSession session = request.getSession();
//        session.getAttribute("username");
//        session.getAttribute("event");

				return "EventHeadHomePage";
		
	}
	
	@RequestMapping(value="/VolunteerHomePage.htm", method=RequestMethod.GET)
	public String processVolHomePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, AdException {
		
        HttpSession session = request.getSession();
//        session.getAttribute("username");
//        session.getAttribute("event");

				return "VolunteerHomePage";
		
	}
	
	
	@RequestMapping(value="/logout.htm", method=RequestMethod.GET)
	public String logoutRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, AdException {
			HttpSession session = request.getSession();
			
			session.invalidate();
			return "LoginForm";
		
	}
}
