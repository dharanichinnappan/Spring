package com.dharani.hibernate.one_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.one_to_many.entity.Course;
import com.dharani.hibernate.one_to_many.entity.Instructor;
import com.dharani.hibernate.one_to_many.entity.InstructorDetail;

public class DeleteCourse {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("Hibernate_configuration.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			int Id = 4;
			Course course = session.get(Course.class, Id);
			System.out.println("Deleting course: "+course);
			session.delete(course);
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			session.close();
		}

	}

}
