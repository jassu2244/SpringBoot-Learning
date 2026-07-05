package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

//In level 1 caching we had separate cache for every object but in level 2 we have cache at session factory level
//In level 2 caching we just have 1 cache at session factory level means application level so we have one common cache memory for 
//all the session objects doesn't matter how many objects we create
// And to perform level 2 caching we need Eh cache (see comments in cfg.xml file comments)

public class GetRecordAppLCache 
{

	public static void main(String[] args) 
	{
			SessionFactory sessionFactory = new Configuration().configure()
					.addAnnotatedClass(Student.class).buildSessionFactory();
			Session session1 =null;
			Session session2=null;
			
			try
			{
			   session1 = sessionFactory.openSession();
		
			   Student student = session1.get(Student.class, 1);
			   System.out.println(student);
			   
			   Student students = session1.get(Student.class, 1);
			   System.out.println(students);
			   
			   session2 = sessionFactory.openSession();
			   Student student2 = session2.get(Student.class, 1);
			   System.out.println(student2);
			   Student student3 = session2.get(Student.class, 1);
			   System.out.println(student3);
			   //Student student = session.load(Student.class, 1);
			   //Student student = session.getReference(Student.class, 1);

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
			    session1.close();
			    session2.close();
			    sessionFactory.close();
			}
		


	}

}
