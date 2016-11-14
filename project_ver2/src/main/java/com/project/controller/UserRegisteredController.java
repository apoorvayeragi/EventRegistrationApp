package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

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
@RequestMapping("/useradded.htm")
public class UserRegisteredController {

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("inside dosubmitAction");
		System.out.println(user);
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "Register";
		}
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String role= request.getParameter("role");
		System.out.println("role="+role);
		session.setAttribute("username", username);
		session.setAttribute("role", role);
		UserDAO userDao = new UserDAO();
		System.out.print("test1");
		User myNewUser  = user;
		System.out.println(myNewUser);
		userDao.saveUser(myNewUser);
		
//---commented for testing--------------------
//		try {
//			System.out.print("test");
//			UserDAO userDao = new UserDAO();
//			System.out.print("test1");
//			
//			userDao.create(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getGender(),user.getUserName(), user.getPassword(), user.getRole(), user.getStatus());
//			
//			// DAO.close();
//		} catch (AdException e) {
//			System.out.println("Exception: " + e.getMessage());
//		}

		return "UserRegistered";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, AdException {
		HttpSession session = request.getSession();
		
		session.invalidate();
		return "Register";
	}
}
