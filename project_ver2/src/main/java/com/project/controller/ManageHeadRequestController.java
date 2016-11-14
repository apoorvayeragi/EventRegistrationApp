package com.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.UserDAO;
import com.project.exception.AdException;
import com.project.pojo.Event;
//import com.project.pojo.EventHead;
import com.project.pojo.User;

@Controller
public class ManageHeadRequestController {
	
	@Autowired
	UserDAO userDAO;
	

	@RequestMapping(method = RequestMethod.GET, value="/ManageEventHeadRequest.htm")
	public ModelAndView manageRequest(HttpServletRequest request, HttpServletResponse res,HttpSession session) throws AdException{
        
        
        List<User> userList = userDAO.getEventsHeadRequest();
        List<User> newUserList = new ArrayList<User>() ;
        Iterator userIterator = userList.iterator();

        while (userIterator.hasNext())
        {
            User user = (User) userIterator.next();
            newUserList.add(user);
            
        }
        for(User ev : userList){
        	System.out.println(ev.getUserName());
        }

        //List<User> userList = userDAO.getEventsHeadRequest();
//        userList.list();
		
        ModelAndView mv = new ModelAndView("ManageHeadRequest","headRequest", newUserList);
		return mv;
			//return "ManageHeadRequest";		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/headAccept.htm")
	public ModelAndView headAccept(HttpServletRequest request, HttpServletResponse res) throws AdException {
        
		HttpSession session = request.getSession();
		System.out.println("reached headAccept");
		String username = request.getParameter("username");
		System.out.println(" usernamae is --- " +username);
		//session.setAttribute("event", userDAO.updateUserStatus(username, "Accepted"));
		userDAO.updateUserStatus(username, "Accepted");
		
		List<User> userList = userDAO.getEventsHeadRequest();
        List<User> newUserList = new ArrayList<User>() ;
        Iterator userIterator = userList.iterator();

        while (userIterator.hasNext())
        {
            User user = (User) userIterator.next();
            newUserList.add(user);
            
        }
        for(User ev : userList){
        	System.out.println(ev.getUserName());
        }
		
        ModelAndView mv = new ModelAndView("ManageHeadRequest","headRequest", newUserList);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/headReject.htm")
	public ModelAndView headReject(HttpServletRequest request, HttpServletResponse res) throws AdException {
	
		HttpSession session = request.getSession();
		System.out.println("reached headAccept");
		String username = request.getParameter("username");
		System.out.println(" usernamae is --- " +username);
		//session.setAttribute("event", userDAO.updateUserStatus(username, "Accepted"));
		userDAO.updateUserStatus(username, "Rejected");
		
		List<User> userList = userDAO.getEventsHeadRequest();
        List<User> newUserList = new ArrayList<User>() ;
        Iterator userIterator = userList.iterator();

        while (userIterator.hasNext())
        {
            User user = (User) userIterator.next();
            newUserList.add(user);
            
        }
        for(User ev : userList){
        	System.out.println(ev.getUserName());
        }
		
        ModelAndView mv = new ModelAndView("ManageHeadRequest","headRequest", newUserList);
		return mv;
	}

}
