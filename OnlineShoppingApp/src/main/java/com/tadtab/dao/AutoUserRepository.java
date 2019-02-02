package com.tadtab.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tadtab.core.authentication.AutoUser;
import com.tadtab.core.authentication.User;


public class AutoUserRepository  {
	
	private static final Logger LOGGER = Logger.getLogger(AutoUserRepository.class);
	
	public AutoUserRepository() {}
	  
	  SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	  Session session = null;
	  
	 
	  
	private List<AutoUser> getAllUsers() {
		
			List<AutoUser> principalList = new ArrayList<>(); 
			
		    session = sessionfactory.openSession();
		    session.beginTransaction();
		
		    List<AutoUser> query = session.createQuery("from AutoUser").list();
		    principalList = query;
		    
		    LOGGER.debug("From Logger : total size of the principlas is " + query.size());
		    System.out.println("total size of the principlas is " + query.size());
		    session.getTransaction().commit();
		    session.close();
		
		return principalList;
	}
	
	public AutoUser findByUsername(String userName) {
		
		AutoUser currentUser = null;
		
	    session = sessionfactory.openSession();
	    session.beginTransaction();
	    
	    List<AutoUser> allPrincipals = session.createQuery("from AutoUser").list();
	    Iterator<AutoUser> it = allPrincipals.iterator();
	    
	    while(it.hasNext()) {
	    	AutoUser userAtCursor = it.next();
	    		if(userName.equals(userAtCursor.getUsername())) {
	    			currentUser = userAtCursor;
	    			break;
	    		}
	    }
	   
	    session.getTransaction().commit();
	    session.close();
	
	return currentUser;
}
	
}
