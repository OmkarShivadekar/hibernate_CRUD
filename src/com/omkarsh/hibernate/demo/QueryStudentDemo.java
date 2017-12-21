package com.omkarsh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omkarsh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		try{
			//create a student object 
			System.out.println("Creating new Student Object...");
			Student tempStudent1 = new Student("Mukesh","Borana","mukesh@omkarsh.com");
			Student tempStudent2 = new Student("Sarang","Kamble","sarang@omkarsh.com");
			Student tempStudent3 = new Student("Himanshu","Patel","himan@omkarsh.com");
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student..");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally{
			factory.close();
		}

	}

}
