package com.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.demo.factory.HibernateSessionFactory;

public class AddBook {

	
	public static void main(String[] args) {
		
		SessionFactory factory=HibernateSessionFactory.getSessionFactory();
		
		
		Session session=factory.openSession();         //Session session=factory.getCurrentSession()
		
		
		session.getTransaction().begin();
		
		Book book=new Book("M407", "MEAN in action", "bar", new Date(), 700);
		book.setRank(2);
		
		session.save(book);
		
		
		session.getTransaction().commit();
		
		session.close();
		
		factory.close();
	}
}













