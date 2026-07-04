package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class LaunchStandardApp {
	public static void main(String[] args) {
		
		//Creating all reference variables needed.
		Configuration config = null; // this object to load configuration file
		SessionFactory sessionFactory = null; // to create the session
		Session session = null; // getting one session object
		Transaction transaction = null; // to perform non select operations
		boolean flag = false;
		
		config = new Configuration();
		config.configure(); // when name is hibernate.cfg.xml no need to give name here
		
		sessionFactory = config.buildSessionFactory();
		
		session = sessionFactory.openSession(); // this will give me a session object.
		
		Student student = new Student();
		student.setSid(2);
		student.setSname("Rahul");
		student.setScity("Pune");
		
		try {
			transaction = session.beginTransaction(); // this will give me transaction object
			session.persist(student); // to insert the data we using .persist(); method
			flag = true; // this line will only execute when above 2 lines run properly
		}
		
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// this is like following acid property that either transaction if fully completed or nothing going to happen
			if(flag == true) {
				transaction.commit();
			} 
			else {
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();
		}
	}
}
