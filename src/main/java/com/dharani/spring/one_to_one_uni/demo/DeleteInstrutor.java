package com.dharani.hibernate.one_to_one_uni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstrutor {
	public static void main(String[] args) {
		// Create Session factory

		SessionFactory sessionFactory = new Configuration().configure("Hibernate_congif.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// WE can just write .configure() without configuration xml file name.. but will
		// search for default hibernate configuration file "hibernate.cfg.xml"

		// Create Session
		Session session = sessionFactory.getCurrentSession();
		try {

			session.beginTransaction();

			// System.out.println(instructor);
			Instructor instructor = session.get(Instructor.class, 4);
			System.out.println("Instrutor to Delete" + instructor);
			// Delete the Instructor because it will delete InstrutorDetail because of
			// cascading.
			session.delete(instructor);
			System.out.println("Instrutor deleted");
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
}
