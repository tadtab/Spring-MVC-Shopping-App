package com.tadtab.dao;

import com.tadtab.core.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
  SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
  Session session = null;
  List<Product> productList;
  
  public ProductDAO() {}
  
  public List<Product> returnPruductList() { productList = new ArrayList();
    session = sessionfactory.openSession();
    session.beginTransaction();
    
    List<Product> query = session.createQuery("from Product").list();
    productList = query;
    
    session.getTransaction().commit();
    session.close();
    return productList;
  }
  
  public Product returnCurrentPruduct(int id)
  {
    Product currentProductp = null;
    
    session = sessionfactory.openSession();
    session.beginTransaction();
    
    List<Product> query = session.createQuery("from Product").list();
    
    for (Product p : query) {
      if (p.getId() == id) {
        currentProductp = p;
        break;
      }
    }
    

    session.getTransaction().commit();
    session.close();
    
    return currentProductp;
  }
  
  public void persistProduct(Product FreshProduct) {
    session = sessionfactory.openSession();
    session.beginTransaction();
    
    session.save(FreshProduct);
    System.out.println("Product to be persisted ID from DAO =" + FreshProduct.getId());
    
    session.getTransaction().commit();
    session.close();
  }
  
  public void deleteProductFromDB(int id) {
    session = sessionfactory.openSession();
    session.beginTransaction();
    
    Product currentProduct = null;
    
    List<Product> query = session.createQuery("from Product").list();
    
    for (Product p : query) {
      if (p.getId() == id) {
        currentProduct = p;
        break;
      }
    }
    
    session.delete(currentProduct);
    
    session.getTransaction().commit();
    session.close();
  }
  
  public void editProduct(Product product) {
    session = sessionfactory.openSession();
    session.beginTransaction();
    
    session.update(product);
    
    session.getTransaction().commit();
    session.close();
  }
}