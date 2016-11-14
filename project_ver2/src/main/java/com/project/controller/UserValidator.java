package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import javax.xml.bind.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.dao.UserDAO;
import com.project.pojo.Address;
import com.project.pojo.User;

@Component
public class UserValidator implements Validator{

	
	public boolean supports(Class aClass)
    {
		 //TODO Auto-generated method stub
        return aClass.equals(User.class);
    }
	
	public void validate(Object obj, Errors errors)
    {
		 //TODO Auto-generated method stub
		User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user.firstName", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user.lastName", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user.userName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.user.gender", "Gender Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "error.invalid.user.role", "Role Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.user.phone", "phone Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.user.emailId", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.streetName", "error.invalid.address.streetName", "streetName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "error.invalid.address.city", "city Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.state", "error.invalid.address.state", "state Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.country", "error.invalid.address.country", "country Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.zipCode", "error.invalid.address.zipCode", "zipCode Required");
        
        UserDAO userDAO = new UserDAO();
        System.out.println("email address: "+user.getEmail());
        if(userDAO.checkIfEmailIsUnique(user.getEmail())){
        	System.out.println("email is unique");
        }
        else{
        	errors.rejectValue("email", "error.invalid.user.emailId", "Email Address Already Exists");
        }
        
        //for username
        System.out.println("username: "+user.getUserName());
        if(userDAO.checkIfUserNameIsUnique(user.getUserName())){
        	System.out.println("user is unique");
        }
        else{
        	errors.rejectValue("userName", "error.invalid.user.userName", "Username Already Exists");
        }

        System.out.println("phone: "+user.getPhone());
        if(userDAO.validatePhoneNumber(user.getPhone())){
        	System.out.println("phone number is valid");
        }
        else{
        	errors.rejectValue("phone", "error.invalid.user.phone", "Phone number not valid");
        }
        
        user.setFirstName(user.getFirstName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim());
        user.setLastName(user.getLastName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim());
        user.setUserName(user.getUserName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim());
        
    }
}
