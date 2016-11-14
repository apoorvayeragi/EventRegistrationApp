package com.project.Saved;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.pojo.Person;
import com.project.pojo.User;

public class InitialData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User u = new User();
		
		u.setFirstName("Samy");
		u.setLastName("Dani");
		u.setPhone("5658946565");
		u.setEmail("jasdhkjahd@kjsdkajd");
		u.setUserName("use1");
		u.setPassword("password");
	
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		System.out.println("Object Saved");
	}

}
