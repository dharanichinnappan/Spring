package com.dharani.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		// Create Session factory

		SessionFactory sessionFactory = new Configuration().configure("Hibernate_congif.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		// WE can just write .configure() without configuration xml file name.. but will
		// search for default hibernate configuration file "hibernate.cfg.xml"

		// Create Session
		Session session = sessionFactory.getCurrentSession();
		try {
			
			System.out.println("creating new Student");
			Student student = new Student("Dharani", "C", "cdd@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println(student.getId() + "  is student Id");
			
			
			// Reading data from database
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Reading student with Id " + student.getId());
			Student tempStudent = session.get(Student.class, student.getId());
			System.out.println("Got details of Student " + tempStudent);
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			sessionFactory.close();
		}
	}

}
