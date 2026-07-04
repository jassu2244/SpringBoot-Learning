package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class GetRecordApp {

	public static void main(String[] args) {
		// this is Level 1 caching or L1 caching
			SessionFactory sessionFactory = new Configuration().configure()
					.addAnnotatedClass(Student.class).buildSessionFactory();
			Session session1 =null;
			Session session2=null; 
			// Here we are only retrieving the data so transaction object is not needed
			
			try {
			   session1 = sessionFactory.openSession();
			   session2 = sessionFactory.openSession();
			   Student student = session1.get(Student.class, 1); // this method is used to retrieve the data from db
			   System.out.println(student);
			   
			   Student students = session1.get(Student.class, 1); // get method does eager loading
			   System.out.println(students);
			   
			   
			   Student student2 = session2.get(Student.class, 1);
			   System.out.println(student2);
			   Student student3 = session2.get(Student.class, 1);
			   System.out.println(student3);
			   
			   //THIS COMPLETE THING IS CALLED LAZY LOADING
			   
			   //Student student = session.load(Student.class, 1); // this method is depricated, here 2 objects are created, 
//			   1-Proxy object and 2-Actual object
			   
			   
// this is used to do LAZY LOADING, here hibernate will create an environment, create an object then load the query 
// When proxy object is created it is created with only Primary key and when i ask to get more details and fetch the data from db,
// then it generate the query, create a jdbc environment then it creates actual object that is why here 2 times 
//	constructor is getting called and this object is based on the actual data from db and this data is passed to Student object
			   
			   
//			   Student student = session.getReference(Student.class, 1); // this method is used in place of load method
			   
//			   if(student!=null){
//			   System.out.println("Id is : "+ student.getSid());
//			  // System.in.read();
//			   System.out.println("Name is : "+ student.getsName());
//			   System.out.println("City is : "+ student.getScity());
//			   }
//			   else {
//				   System.out.println("There is no data/record with given id");
//			   }

			}
			catch(HibernateException e) {
				e.printStackTrace();
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
			finally {
			  session1.close();
			  sessionFactory.close();
		}
	}
}
