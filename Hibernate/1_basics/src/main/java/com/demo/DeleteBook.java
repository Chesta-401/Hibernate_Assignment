package com.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.factory.HibernateSessionFactory;

public class DeleteBook {
	
	public static void main(String[] args) {
		SessionFactory factory=HibernateSessionFactory.getSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.getTransaction();
		try {
			tx.begin();
			Book book=session.get(Book.class, 3);
		
			if(book!=null) {
				session.delete(book);
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





