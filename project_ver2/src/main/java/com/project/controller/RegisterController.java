package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dao.UserDAO;
import com.project.pojo.User;



@Controller
//@RequestMapping("/register.htm")
public class RegisterController {
//	@Autowired
//	@Qualifier("userValidator")
//	UserValidator validator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

//	@RequestMapping(method = RequestMethod.GET)
//	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "Register";
//		}
//
//		System.out.print("test");
//		UserDAO userDao = new UserDAO();
//		System.out.print("test1");
//
//		return "Register";
//	}
//
	//@RequestMapping("/register.htm")
	public String processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        System.out.println("in the controolwerrjyfyf");
        return("Register");
	}
	
}
