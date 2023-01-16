package com.ruiz.sms.SRuizSMS.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table
public class Student implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	@Id
	private String email;
	private String fullName;
	private String passowrd;
	
	/**
	 * Student is the source
	 * Course is the target
	 * A students can be in many courses
	 * Courses can have many students
	 * created a course object
	 */
	@ManyToMany(targetEntity = Course.class)
	private Course course;
	
	
	public Student() {}
	
	
	
	public Student(String email, String fullName, String passowrd) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.passowrd = passowrd;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}



	@Override
	public String toString() {
		return "Student id:" + id + " | email:" + email + " | fullName:" + fullName + " | passowrd:" + passowrd;
	}



	@Override
	public int hashCode() {
		return Objects.hash(email, fullName, id, passowrd);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName) && id == other.id
				&& Objects.equals(passowrd, other.passowrd);
	}
	
	
	
}
