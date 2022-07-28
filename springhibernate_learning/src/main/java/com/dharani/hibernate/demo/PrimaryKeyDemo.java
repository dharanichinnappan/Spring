package com.dharani.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dharani.hibernate.entity.Student;

public class PrimaryKeyDemo {

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
					System.out.println("creating new Students");
					Student student = new Student("PRaveen", "Kumar", "praveen@gmail.com");
					Student student1 = new Student("Dhiva", "Chinnappan", "cdhiva@gmail.com");
					Student student2 = new Student("Dhuruv", "Praveeen", "dhuruv@gmail.com");
					session.beginTransaction();
					session.save(student);
					session.save(student1);
					session.save(student2);
					session.getTransaction().commit();
					System.out.println("Students saved");
				} finally {
					session.close();
				}
			}

	}


