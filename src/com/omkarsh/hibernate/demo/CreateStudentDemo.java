package com.omkarsh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omkarsh.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		try{
			//start a transaction
			session.beginTransaction();
		
			//query students
			List<Student> theStudent = session.createQuery("from Student").list();
			
			//display the students
			displayStudents(theStudent);
			
			//query students : lastName='Shivadekar'
			theStudent=session.createQuery("from Student s where s.lastName='Shivadekar'").list();
			
			//display the students
			System.out.println("\nStudent who has last name of Shivadekar");
			displayStudents(theStudent);
			
			//query students : lastName='Shivadekar' or firstname='Mukesh'
			theStudent=session.createQuery("from Student s where s.lastName='Shivadekar' OR s.firstName='Mukesh'").list();
		
			System.out.println("\nStudent who has last name of Shivadekar or last name of Mukesh");
			displayStudents(theStudent);
			
			//query students where email LIKE '%omkarsh.com'
			theStudent=session.createQuery("from Student s where s.email LIKE '%omkarsh.com'").list();
			
			System.out.println("\nStudent who has email ends with omkarsh.com");
			displayStudents(theStudent);
			
			
			
			
			
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudent) {
		for( Student tempStudent:theStudent)
		{
			System.out.println(tempStudent);
		}
	}

}
