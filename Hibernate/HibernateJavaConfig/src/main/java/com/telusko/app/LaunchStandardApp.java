package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class LaunchStandardApp 
{

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		config = new Configuration();
		
		//this is used to give all the db properties so if i use like this i don't need to jave hibernate.cfg.xml file
		//we can do it like this using java only, but this is not good practice
		//so here we just created a simple file hibernate.properties so configuration object will automatically identifies
		//what to configure
		
		//IF YOU WANT TO GIVE MAPPING AND OTHER THINGS THEN WE CAN GO WITH XML APPROACH THAT WE WERE USING TILL NOW LIKE IN OTHER FILES
		
//		config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/telusko_db");
//		config.setProperty("hibernate.connection.password", "my_sql_passowrd");
//		config.setProperty("hibernate.connection.username", "root");
//		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		config.setProperty("hibernate.hbm2ddl.auto", "update");
//		config.setProperty("hibernate.show_sql", "true");
//		config.setProperty("hibernate.format_sql", "true");
		
		
		config.addAnnotatedClass(Student.class); // this is mapping class

		sessionFactory = config.buildSessionFactory();
		
		session = sessionFactory.openSession();
		
		Student student = new Student();
		student.setSid(3);
		student.setsName("Akhilesh");
		student.setScity("Bengaluru");
		
		try
		{
			transaction = session.beginTransaction(); //using this because we are performing non select operation
			//session.save(student);
			session.merge(student); // Hibernate 6: updates if the record exists, otherwise inserts
			flag = true;
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(flag == true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}
	}
}