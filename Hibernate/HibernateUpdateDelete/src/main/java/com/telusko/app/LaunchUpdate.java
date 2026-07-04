package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class LaunchUpdate {

	public static void main(String[] args) { 
		//this is not optimised way
//		Configuration config = new Configuration();
//		config.configure();
//		config.addAnnotatedClass(Student.class)
//		SessionFactory sessionFactory = config.buildSessionFactory();
		
		SessionFactory sessionFactory = new Configuration().configure().
				addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction(); // this will give me transaction object because non select operation are being performed
			
			Student st = new Student();
			st.setSid(3);
			st.setSname("Harsh");
			st.setScity("Jaipur");
			
			session.merge(st); // this method is used to perform update in db
			//session.saveOrUpdate(st); // this means if present then update else insert a new record, this is also depricated
			//session.update(st); // this method id depricated
			flag = true;
		}
		
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
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
