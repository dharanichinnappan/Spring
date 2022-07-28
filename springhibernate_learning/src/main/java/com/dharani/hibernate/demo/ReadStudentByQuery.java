package com.dharani.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.entity.Student;

public class ReadStudentByQuery {

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

			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList(); // --> Here use Java class
																							// name "Student"
			/*
			 * Right click below code refactor->Extract Method for(Student s:students2) {
			 * System.out.println(s); }
			 */
			displayStudents(students);

			List<Student> students2 = session.createQuery("from Student s where s.lastName='Chinnappan'")
					.getResultList(); // --> Here use java field name "lastName"
										// not table column name(last_name) .
			displayStudents(students2);

			List<Student> students3 = session
					.createQuery("from Student s where s.lastName='Chinnappan' OR s.firstName='Dharani'")
					.getResultList(); // --> Here use java field name "lastName" & "firstName"
			// not table column name(last_name,first_name) .
			displayStudents(students3);

			List<Student> students4 = session.createQuery("from Student s where s.email LIKE '%sss.com'")
					.getResultList();
			displayStudents(students4);

			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> students2) {
		for (Student s : students2) {
			System.out.println(s.getFirstName()+s.getLastName()+s.getId());
		}
	}

}
