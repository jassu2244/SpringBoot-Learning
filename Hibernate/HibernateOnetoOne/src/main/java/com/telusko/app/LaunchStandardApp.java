package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Answer;
import com.telusko.model.Question;



//When we write:
		//
		//Configuration config = new Configuration();
		//config.addAnnotatedClass(Student.class);
		//SessionFactory sessionFactory = config.buildSessionFactory();
		//
		//we are telling Hibernate:
		//
		//"This Student class is an Entity. Read all the annotations (@Entity, @Table,
		//@Id, @Column, etc.) and map this Java class to its corresponding database table."
		//
		//Why is mapping required?
		//
		//Hibernate has no idea which Java classes represent database tables.
		//A project may contain hundreds of Java classes, but not every class is an Entity.
		//So we explicitly tell Hibernate which classes should be managed.
		//
		//After reading the annotations, Hibernate creates metadata such as:
		//
		//Student.class
//		        ↓
		//@Table(name = "StudentTable")
//		        ↓
		//StudentTable
//		        ↓
		//SID     → Primary Key
		//SNAME   → Column
		//SCITY   → Column
		//
		//This metadata is used whenever we perform operations like:
		//session.persist()
		//session.merge()
		//session.remove()
		//session.get()
		//
		//Without this mapping, Hibernate doesn't know where to store or retrieve data
		//and throws:
		//
		//org.hibernate.UnknownEntityTypeException
		//or
		//Unknown entity: com.telusko.model.Student
		//
		//If we use hibernate.cfg.xml, we can register entities there using:
		//
		//<mapping class="com.telusko.model.Student"/>
		//
		//In Java Configuration, instead of XML mapping, we register entities using:
		//
		//config.addAnnotatedClass(Student.class);
		//
		//This is why adding the annotated class is an essential step before building
		//the SessionFactory.


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
		
		config.configure();

		sessionFactory = config.buildSessionFactory();
		
		session = sessionFactory.openSession();
		
		Question q1 = new Question();
		q1.setId(1);
		q1.setQuestion("What is Hibernate?");
		
		Answer answer1 = new Answer();
		answer1.setId(1);
		answer1.setAnswer("Hibernate is an ORM Framewok");
		
		q1.setAnswer(answer1);
		answer1.setQuestion(q1);
		
		
		
		Question q2 = new Question();
		q2.setId(2);
		q2.setQuestion("What is JPA?");
		
		Answer answer2 = new Answer();
		answer2.setId(2);
		answer2.setAnswer("It is a specificatiion used to persist "
				+ "data between Java object and relational database.");
		
		q2.setAnswer(answer2);
		answer2.setQuestion(q2);
		
		//this is to print the question and answer along with each other in console
//		Question qa = session.get(Question.class, 1);
//		System.out.println(qa);
		
		try
		{
			transaction = session.beginTransaction();
			//session.save(student);
			session.persist(q1);
			session.persist(q2);
			
//			session.persist(answer1);
//			session.persist(answer2);
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
