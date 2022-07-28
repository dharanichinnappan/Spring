package com.dharani.hibernate.one_to_many.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.one_to_many.entity.Course;
import com.dharani.hibernate.one_to_many.entity.Instructor;
import com.dharani.hibernate.one_to_many.entity.InstructorDetail;

public class CreateCourse {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("Hibernate_configuration.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			// 1.get Instructor from db.
			// 2.create some courses
			// 3.add courses to Instructor
			// 4. Save the courses.

			int Id = 1;
			Instructor instructor = session.get(Instructor.class, Id);
			Course course1 = new Course("tennis Course");
			Course course2 = new Course("swimming Course");
			// --> the following code doesnt work. this adds courses only to courses table
			/*
			 * ArrayList<Course> courses = new ArrayList<Course>(); courses.add(course1);
			 * courses.add(course2); instructor.setCourses(courses);
			 */
			instructor.add(course1);
			instructor.add(course2);

			session.save(course1);
			session.save(course2);
			System.out.println("Done");
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}

}
