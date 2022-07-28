package com.dharani.hibernate.one_to_many.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.one_to_many.entity.Course;
import com.dharani.hibernate.one_to_many.entity.Instructor;
import com.dharani.hibernate.one_to_many.entity.InstructorDetail;

public class GetInstructorCourses {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("Hibernate_configuration.xml")
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();
			int id = 1;
			int i = 0;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Instructor Details:  " + instructor.getFirstName() + " " + instructor.getLastName());
			System.out.println("Courses of Instructor" + instructor.getCourses());
			List<Course> courseList = new ArrayList<Course>();
			System.out.println("Sie of courses List" + instructor.getCourses().size());
			while (i < instructor.getCourses().size()) {
				courseList.add(instructor.getCourses().get(i));
				i++;

			}

			for (Course course : courseList) {
				System.out.println(course.getId() + course.getTitle());
			}
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			session.close();
		}

	}

}
