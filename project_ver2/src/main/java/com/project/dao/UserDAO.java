package com.project.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.exception.AdException;
import com.project.pojo.Event;
import com.project.pojo.Event_Volunteer;
import com.project.pojo.Person;
//import com.project.pojo.EventHead;
import com.project.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {

	}

	public User get(String username) throws AdException {

		try {
			begin();
			Query q = getSession().createQuery("from usertable where userName = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + username, e);
		}
	}

	public User create(String firstName, String lastName, String email, String phone, String birthDate,String gender, String username,
			String password, String role, String status) throws AdException {
		try {
			begin();
			System.out.println("inside DAO");
			// Person person = new Person(firstName, lastName, email, phone,
			// birthDate);
			User user = new User(firstName, lastName, email, phone, gender, username, password, role, status);
			getSession().save(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}
	
	//--save
		public long saveUser(User newUser){
			begin();
			getSession().save(newUser.getAddress());
			commit();
			begin();
			long eventID = (Long) getSession().save(newUser);
			commit();
			close();
			begin();
			
			close();
			return eventID;
		}

	public User authenticateUser(String username, String password, String role) {
		try {
			System.out.println("Authenticating User");
			
			Query q = getSession().createQuery("from User u where u.userName = :username and u.password = :password and u.role = :role");
			q.setString("username", username);
			q.setString("password", password);
			q.setString("role", role);
			User user = (User) q.uniqueResult();
			if(user!=null){
				System.out.println(user);
			}
			
			return user;
		} catch (HibernateException e) {

			System.out.println(e);
		}
		return null;
	}
	
	public List<User> getEventsHeadRequest()  throws AdException{
		try {
            begin();								
            Query q = getSession().createQuery("from User where role =:role and status =:value");
            q.setString("role", "EventHead");
            q.setString("value", "requested");
            List<User> headRequestList = q.list();            
            commit();
            close();
            System.out.println("inside dao event list" +headRequestList.size());		
            return headRequestList;
		} catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the events", e);
        }
	}
	
	public List<User> getEventVolunteerRequest(Long event)  throws AdException{
		try {
            begin();
            Criteria  crit = getSession().createCriteria(Event.class);
            crit.add(Restrictions.idEq(event));
            Event events = (Event) crit.uniqueResult();
           Criteria c = getSession().createCriteria(Event_Volunteer.class);
           c.add(Restrictions.eq("event", events));
           c.add(Restrictions.eq("status", "Requested"));
         
        
         
          c.setProjection(Projections.property("user"));
          	List<User> userList= c.list();
            
//            
//            Query q2 = getSession().createQuery("select personId from Event_Volunteer where event =:event and status =:status");
//            //q2.setLong("user", user);
//            q2.setLong("event", event);
//            q2.setString("status", "Requested");
//            List<Long> volpersonList = q2.list();  
//           
//    		//List<Event> notRegEvents = new ArrayList<Event>();
//    		
//    		if(null != volpersonList && volpersonList.size()>0){
//    		
//    		
//    		Criteria c = getSession().createCriteria(Person.class);
//    		
//    			c.add(Restrictions.in("personId", volpersonList));
//    			List<Person> volunteersList =c.list();
    			
    			 commit();
    	            close();
    			return userList;
    		
//    		else{
//    			return null;
//    		}
//    		
    		
		} catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the events", e);
        }
	}
	
	public long getPersonIdFromUserName(String username) throws AdException{
		begin();
		try{
		Query q3 = getSession().createQuery("from User where userName =:userName");
				q3.setString("userName", username);
				User user = (User) q3.uniqueResult();
				if(user!=null){
					return user.getPersonId();
				}
		commit();
        close();
        return 0;
	} catch (HibernateException e) {
        rollback();
        throw new AdException("Could not list the events", e);
    }
	}
	
	
	public User updateUserStatus(String username, String status) {
		try {
			begin();
			System.out.println(status);
			System.out.println(username);
			Query q = getSession().createQuery("update User set status =:status" +
    				" where userName =:username"+ " and role =:role");
			System.out.println("query--"+q);
			q.setParameter("status", status);
			q.setParameter("username", username);
			q.setParameter("role", "Eventhead");
			int result = q.executeUpdate();
			commit();
			close();

		} catch (HibernateException e) {

			System.out.println(e);
		}
		return null;
	}
	
	public Event_Volunteer updateEventVolStatus(User user, Event event, String status ) {
		try {
			begin();
			System.out.println(status);
			System.out.println(user);
			Query q = getSession().createQuery("update Event_Volunteer set status =:status" +
    				" where user =:user"+ " and event =:event");
			System.out.println("query--"+q);
			q.setParameter("event", event);
			q.setParameter("user", user);
			q.setParameter("status", status);
			int result = q.executeUpdate();
			commit();
			close();

		} catch (HibernateException e) {

			System.out.println(e);
		}
		return null;
	}
	
	public User getUserDetails(Long personId){
		
			begin();
			Query q = getSession().createQuery("from User where personId =:personId");
			q.setParameter("personId", personId);
			User user = (User) q.uniqueResult();
			commit();
			close();

		return user;
		
	}
	
	public List<User> getevHeadList(){
		begin();
		Query q = getSession().createQuery("from User where status =:status and role =:role");
		q.setParameter("status", "Accepted");
		q.setParameter("role", "EventHead");
		List<User> user = new ArrayList<User>();
		user =q.list();
		close();
		return user;
	}
	
	public Boolean checkIfEmailIsUnique(String email){
		begin();
		if(!email.isEmpty() && email !=null){
			Query q = getSession().createQuery("from User u where u.email =:value");
			q.setString("value", email);
			try{
				User u = (User) q.uniqueResult();
				if(u !=null){
					return Boolean.FALSE;
				}
				else{
					return Boolean.TRUE;
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}	
		return Boolean.FALSE;
	}
	
	public Boolean checkIfUserNameIsUnique(String username){
		begin();
		if(!username.isEmpty() && username !=null){
			Query q = getSession().createQuery("from User u where u.userName =:value");
			q.setString("value", username);
			try{
				User u = (User) q.uniqueResult();
				if(u !=null){
					return Boolean.FALSE;
				}
				else{
					return Boolean.TRUE;
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}	
		return Boolean.FALSE;
	}
	
		
	
	public boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
        //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        //validating phone number with extension length from 3 to 5
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
        //validating phone number where area code is in braces ()
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
        //return false if nothing matches the input
        else return false;
         
    }
	
	
	
}