package com.dharani.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		// Create Session factory

		SessionFactory sessionFactory = new Configuration().configure("Hibernate_congif.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		// WE can just write .configure() without configuration xml file name.. but will
		// search for default hibernate configuration file "hibernate.cfg.xml"

		// Create Session
		Session session = sessionFactory.getCurrentSession();
		try {
            //use session object to save Java Object
			System.out.println("creating new Student");
			Student student = new Student("Dharani", "C", "cddddd@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Student saved");
		} finally {
			session.close();
		}
	}

}
