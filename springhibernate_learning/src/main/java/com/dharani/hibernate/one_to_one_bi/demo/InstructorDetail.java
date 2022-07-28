package com.dharani.hibernate.one_to_one_bi.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	/*
	 * Basics Steps 1.Annotate the class to an Entity and map to db table 2.Define
	 * the fields 3.Annotate field with column name 4.create constructor 5.generate
	 * getters and setters 6.generate toString() method for debugging
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	@Column(name = "hobby")
	private String hobby;

	// add new field for Instructor
	/*
	 * @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL) // Refers
	 * to instructorDetail field in // Instructor class
	 */
	
	// to Delete only InstructorDetail (not Instructor .. we need to change Cascade
	// type all to type except remove)
	@OneToOne(mappedBy = "instructorDetail", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Instructor instructor;

	public InstructorDetail() {

	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

}
