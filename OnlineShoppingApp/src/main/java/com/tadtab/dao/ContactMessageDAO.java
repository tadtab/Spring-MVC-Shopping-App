package com.tadtab.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tadtab.core.pojo.ContactUsMessage;

public class ContactMessageDAO {
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	  Session session = null;
	  
	  public void persistMessage(ContactUsMessage contactUsMessage) {
		  session = sessionfactory.openSession();
		  session.beginTransaction();
		  
		  	session.save(contactUsMessage);
		  
		  session.getTransaction().commit();
		  session.close();
		  	
	  }
	  
	  public List<ContactUsMessage> pretrieveMessage() {
		  session = sessionfactory.openSession();
		  session.beginTransaction();
		  
		  	List<ContactUsMessage> messagesList = session.createQuery("from ContactUsMessage").list();
		  
		  session.getTransaction().commit();
		  session.close();
		  
		  return messagesList;
		  	
	  }

}
