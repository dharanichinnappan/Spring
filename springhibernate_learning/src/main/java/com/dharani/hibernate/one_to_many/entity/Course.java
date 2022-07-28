package com.dharani.hibernate.one_to_many.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Basics Steps 1.Annotate the class to an Entity and map to db table
 *  2.Define the fields
 *   3.Annotate field with column name
 *    4.create constructor
 *     5.generate getters and setters
 *      6.generate toString() method for debugging
 */

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.MERGE , CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH} )
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	public Course(String title) {
		this.title = title;

	}

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	
}
