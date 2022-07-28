package com.dharani.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		// Create Session factory

		SessionFactory sessionFactory = new Configuration().configure("Hibernate_congif.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		// WE can just write .configure() without configuration xml file name.. but will
		// search for default hibernate configuration file "hibernate.cfg.xml"

		// Create Session
		Session session = sessionFactory.getCurrentSession();
		try {

			int id = 1;

			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Reading student with Id " + id);
			Student tempStudent = session.get(Student.class, id);
			System.out.println("Got details of Student " + tempStudent);
			tempStudent.setFirstName("New");
			session.getTransaction().commit();
			System.out.println("Details of Student after update " + tempStudent);

			// Update Using Query
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='xxx@gmai.com' where email LIKE 'cdd%' ").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			sessionFactory.close();
		}
	}

}
