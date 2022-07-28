package com.dharani.hibernate.one_to_one_bi.demo;

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

			/*
			 * session.beginTransaction(); int id = 7; InstructorDetail instructorDetail =
			 * session.get(InstructorDetail.class, id);
			 * System.out.println("Instrutor to Delete" + instructorDetail);
			 * System.out.println("trying to fetch Instrutor based on InstructorDetail" +
			 * instructorDetail.getInstructor()); // Delete the InstructorDetail because it
			 * will delete Instrutor because of // cascading.
			 * session.delete(instructorDetail);
			 * System.out.println("Only InstrutorDetail deleted");
			 * session.getTransaction().commit();
			 */
			
			//To Delete only instructorDetail
			
			session.beginTransaction();
			int id = 7;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			System.out.println("Instrutor to Delete" + instructorDetail);
			System.out.println("trying to fetch Instrutor based on InstructorDetail" + instructorDetail.getInstructor());
			//set associated Instructor's InstrutorDetail to null.
			instructorDetail.getInstructor().setInstructorDetail(null);
			// Delete the InstructorDetail
			session.delete(instructorDetail);
			System.out.println("Only InstrutorDetail deleted");
			session.getTransaction().commit();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
