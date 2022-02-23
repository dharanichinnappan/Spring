package com.dharani.hibernate.one_to_many.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.one_to_many.entity.Course;
import com.dharani.hibernate.one_to_many.entity.Instructor;
import com.dharani.hibernate.one_to_many.entity.InstructorDetail;

public class CreateInstructor {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("Hibernate_configuration.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			Instructor instructor = new Instructor("Dharani", "C", "cddd@gmail.com");

			InstructorDetail detail = new InstructorDetail("cddelights", "Cooking");
			instructor.setInstructorDetail(detail);
			System.out.println("Done");
			session.save(instructor);
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

}
