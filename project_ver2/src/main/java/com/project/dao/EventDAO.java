package com.project.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.project.exception.AdException;
import com.project.pojo.Address;
import com.project.pojo.Event;
import com.project.pojo.Event_Volunteer;
import com.project.pojo.User;

public class EventDAO extends DAO{


	public EventDAO() {

	}
	
	//--list
	public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Event");
            List<Event> list = q.list();
            commit();
            close();
            System.out.println("inside dao event list" +list.size());
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the events", e);
        }
    }

	//--save
	public long saveEvent(Event newEvent){
		begin();
		getSession().save(newEvent.getAddress());
		commit();
		begin();
		long eventID = (Long) getSession().save(newEvent);
		commit();
		close();
		return eventID;
	}
	
	public List<Event> getEventsUnderHead(String username)  throws AdException{
		try {
            begin();								
            Query q = getSession().createQuery("from Event where eventHeadName =:username");
            q.setString("username", username);
            List<Event> eventList = q.list();            
            commit();
            close();
            System.out.println("inside dao event list" +eventList.size());		
            return eventList;
		} catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the events", e);
        }
	}

	
	public long saveEventVol(User newUser,long eventId) throws AdException{
		try{
		begin();
		Query q = getSession().createQuery("from Event where eventId =:eventId" );
		q.setLong("eventId", eventId);
		Event event =(Event) q.uniqueResult();
		Event_Volunteer eventVol = new Event_Volunteer();
		eventVol.setStatus("Requested");
		eventVol.setUser(newUser);
		eventVol.setEvent(event);
		long eventIds =(Long) getSession().save(eventVol);
		newUser.getVol_event_records().add(eventVol);
		event.getEvent_vol_records().add(eventVol);
		commit();
		close();
		return eventIds;
		}
		catch(HibernateException e)
		{
			rollback();
			throw new AdException("error adding eventVolunteer request",e);
		}
	}
	
	public List<Event> getRegisteredList(User user)
	{
		Criteria crit=getSession().createCriteria(Event_Volunteer.class);
		crit.add(Restrictions.eq("user", user));
		List regEvents=crit.list();
		List<Event> notRegEvents = new ArrayList<Event>();
		List<Long> eventIds = new ArrayList<Long>();
		if(null != regEvents && regEvents.size()>0){
		
		Iterator it = regEvents.iterator();
		while(it.hasNext())
		{
			Event_Volunteer event =(Event_Volunteer) it.next();
			eventIds.add(event.getEvent().getEventId() );
			
		}
		}
		Criteria c = getSession().createCriteria(Event.class);
		if(null != eventIds && eventIds.size()>0)
			c.add(Restrictions.not(Restrictions.in("eventId", eventIds)));
		
		notRegEvents = c.list();
		System.out.println("notRegEvents"+notRegEvents.size());
		
		//return notRegEvents;
		
		return notRegEvents;
	}
	
		
	public Event getEventDetails(Long eventId){
		
		begin();
		Query q = getSession().createQuery("from Event where eventId =:eventId");
		q.setParameter("eventId", eventId);
		Event event = (Event) q.uniqueResult();
		commit();
		close();

	return event;
}
	
	public Boolean checkIfEventHeadAcepted(String evHead){
		begin();
		if(!evHead.isEmpty() && evHead !=null){
			Query q = getSession().createQuery("from User u where u.userName =:evHead and u.status =:status");
			q.setString("evHead", evHead);
			q.setString("status", "Accepted");
			try{
				User u = (User) q.uniqueResult();
				if(u !=null){
					return Boolean.TRUE;
				}
				else{
					return Boolean.FALSE;
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}	
		return Boolean.FALSE;
	}
	
	public boolean isDateValid(String text) {
	    if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d"))
	        return false;
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    df.setLenient(false);
	    try {
	        df.parse(text);
	        return true;
	    } catch (ParseException ex) {
	        return false;
	    }
	}

	
}