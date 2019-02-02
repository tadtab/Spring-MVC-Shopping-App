package com.tadtab.dao;

import com.tadtab.core.authentication.AutoUser;
import com.tadtab.core.authentication.User;
import com.tadtab.core.pojo.Product;
import com.tadtab.core.pojo.ShoppingCart;
import com.tadtab.core.utility.HibernateUtilities;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAO {
	
	@Autowired
	private ProductDAO productDAO;
	
  public UserDAO() {}
  
  SessionFactory sessionfactory = HibernateUtilities.getSessionFactory();
  Session session = null;
  
  public void signUp(AutoUser autoUser) {
    session = sessionfactory.openSession();
    session.beginTransaction();
    
    
    autoUser.setRole("ROLE_USER");
    
    session.save(autoUser);
    
    session.getTransaction().commit();
    session.close();
  }
  
  List<AutoUser> userList = new ArrayList<>();
  public List<AutoUser> retieveExistingUsers() {
    userList = new java.util.ArrayList();
    session = sessionfactory.openSession();
    session.beginTransaction();
    
    List<AutoUser> query = session.createQuery("from AutoUser").list();
    
    userList = query;
    System.out.println(query.size());
    session.getTransaction().commit();
    session.close();
    
    return userList;
  }
}