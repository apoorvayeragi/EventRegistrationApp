package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dao.EventDAO;
import com.project.exception.AdException;

@Controller
public class SearchController {

	@Autowired
	EventDAO eventDAO;
	
	@RequestMapping(value="/search.htm", method=RequestMethod.POST)
	public String processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, AdException {
		String parameter = request.getParameter("searchkey");
		System.out.println("parameter from jsp is " + parameter);
//		if(parameter == "eventName")
//		{
//			
//		}
//		else if ()
//		
//		
//		
//		
			return null;
//		
	}
	
	
}
