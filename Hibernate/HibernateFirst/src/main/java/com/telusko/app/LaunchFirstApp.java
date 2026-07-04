package com.telusko.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class LaunchFirstApp {

	public static void main(String[] args) {
		//Step 1 - Configuration Object
		Configuration config = new Configuration();
		
		//Step 2 - Configure hibernate.cfg.xml file to Configuration Object
		config.configure(); // you need to specify file name if not default like here inside configure using"".
		
		//Step 3 - Create SessionFactory object
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//Step 4 - Get the session object from Session Factory
		Session session = sessionFactory.openSession();
		
		//Step 5 - Begin transaction within session
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSid(1);
		student.setSname("Rohan");
		student.setScity("Delhi");
		
		//Step 6 - Perform operation using session.save()
		session.save(student);
		
		//Step 7 - Persform transaction operation
		transaction.commit();
		
		//Step 8 - Close the session
		session.close();
	}

}
