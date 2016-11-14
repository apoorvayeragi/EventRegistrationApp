package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.EventDAO;
import com.project.exception.AdException;
import com.project.pojo.Event;
import com.project.pojo.User;

@Controller
public class AdminPageController {

	
	
	@RequestMapping(method = RequestMethod.GET, value="/AdminOfHope.htm")
	public String initializeForm(HttpServletRequest req, HttpServletResponse res) {
		//boolean isLoggedin = false;
		//Session session=(Session) res.getSession();
		
		
			return "AdminLogin";
		
	}
	@RequestMapping(value="/logoutAdmin.htm", method=RequestMethod.GET)
	public String logoutRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, AdException {
			HttpSession session = request.getSession();
			
			session.invalidate();
			return "AdminLogin";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/AddHomePage.htm")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		 System.out.println("12222222222222222222222222222222222222");
		
		HttpSession session = request.getSession();
		ModelAndView mv =commonCode(session);
		return mv;
//		
//		if(null != session.getAttribute("logged")){			
//		
//			EventDAO eventDao = null;
//			List eventList = null;	
//			List<Event> newList = new ArrayList<Event>() ;
//			
//			try {
//				eventDao = new EventDAO();
//				eventList = eventDao.list();
//
//	            Iterator eventIterator = eventList.iterator();
//
//	            while (eventIterator.hasNext())
//	            {
//	                Event event = (Event) eventIterator.next();
//	                newList.add(event);
//	                
//	            }
//	            
//	            System.out.println("sdsdsdsdsdsdsdsdsd" +newList.size());
//	            //DAO.close();
//	        	} catch (AdException e) {
//	            System.out.println(e.getMessage());
//	        }
//	        ModelAndView mv = new ModelAndView("AdminHomePage","event", newList);
//			return mv;
//		
//		}else {
//			ModelAndView mv = new ModelAndView();
//			mv.setViewName("AdminLogin");
//			return mv; 
//		}
	}
	
	public ModelAndView commonCode(HttpSession session)
	{
			
		
		if(null != session.getAttribute("logged") && session.getAttribute("logged").equals("true")){			
		
			EventDAO eventDao = null;
			List eventList = null;	
			List<Event> newList = new ArrayList<Event>() ;
			
			try {
				eventDao = new EventDAO();
				eventList = eventDao.list();

	            Iterator eventIterator = eventList.iterator();

	            while (eventIterator.hasNext())
	            {
	                Event event = (Event) eventIterator.next();
	                newList.add(event);
	                
	            }
	            
	            System.out.println("sdsdsdsdsdsdsdsdsd" +newList.size());
	            //DAO.close();
	        	} catch (AdException e) {
	            System.out.println(e.getMessage());
	        }
	        ModelAndView mv = new ModelAndView("AdminHomePage","event", newList);
			return mv;
		
		}else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("AdminLogin");
			return mv; 
		}
	}
//	@RequestMapping(method=RequestMethod.GET,value="/AddHomePage.htm")
//	public String getEventPage(HttpServletRequest req,HttpServletResponse resp)
//	{
//		HttpSession session = req.getSession();
//		System.out.println(session.getAttribute("logged"));
//		if(null != session.getAttribute("logged")){
//			return "AdminHomePage";
//		}
//		else {
//		return "AdminLogin"; 
//		}		
//	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/AddHomePage.htm")
	public ModelAndView addEvent(HttpServletRequest request, HttpServletResponse res) {

		String username = (String) request.getParameter("adminUser");
		String password = (String) request.getParameter("adminPassword");
		System.out.println(username);
		System.out.println(password);
		
		
		HttpSession session = request.getSession();
		
		if((username.equals("admin"))&&(password.equals("admin"))){
			System.out.println("authenticate");
			//session.setAttribute(isAdminLoggedIn,value=true);
			session.setAttribute("logged", "true");
		}
		else
		{
			session.setAttribute("logged", "false");
		}
		ModelAndView mv =commonCode(session);
		return mv;
//			EventDAO eventDao = null;
//			List eventList = null;	
//			List<Event> newList = new ArrayList<Event>() ;
//			
//			try {
//				eventDao = new EventDAO();
//				eventList = eventDao.list();
//
//	            Iterator eventIterator = eventList.iterator();
//
//	            while (eventIterator.hasNext())
//	            {
//	                Event event = (Event) eventIterator.next();
//	                newList.add(event);
//	                
//	            }
//	            
//	            System.out.println("sdsdsdsdsdsdsdsdsd" +newList.size());
//	            //DAO.close();
//	        	} catch (AdException e) {
//	            System.out.println(e.getMessage());
//	        }
//	        ModelAndView mv = new ModelAndView("AdminHomePage","event", newList);
//			return mv;
//			
//		}else{
//			System.out.println("not");
//			 ModelAndView mv = new ModelAndView("AdminLogin");
//			return mv;
//		}
		
//		if(session.getAttribute("username")!=null){
//			System.out.println("in 1");
//			return "AdminOfHope";
//		}
//			else{
//				System.out.println("in 2");
//				return "AddHomePage";
//		}
		
	}
}
