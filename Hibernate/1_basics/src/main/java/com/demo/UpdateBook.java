package com.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.factory.HibernateSessionFactory;

public class UpdateBook {
	
	public static void main(String[] args) {
		SessionFactory factory=HibernateSessionFactory.getSessionFactory();
		
		Session session=factory.openSession();
		
		//start the tr
		Transaction tx=session.getTransaction();
		try {
			tx.begin();
			//get that object 
			Book book=session.get(Book.class, 3);
			if(book!=null) {
				book.setAuthor("amit kr");
				book.setPrice(book.getPrice()+100);
				session.update(book);
			}else
				System.out.println("book is not found");
			
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		session.close();
		factory.close();
		
	}

}





