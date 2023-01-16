package com.ruiz.sms.SRuizSMS.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Student implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="email",unique=true, nullable=false,length=200)
	private String email;
	private String fullName;
	private String password;
	
	/**
	 * Student is the source
	 * Course is the target
	 * A students can be in many courses
	 * Courses can have many students
	 * created a course object
	 */
	@ManyToMany(targetEntity = Course.class)
	private Set<Course> courseSet;
	
	
	public Student() {
		
		this.email="";
		this.fullName="";
		this.password="";
		this.courseSet = null;
	}
	
	public Student(String email, String fullName, String passowrd) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = passowrd;
	}
	
	
	public Student(String email, String fullName, String passowrd, Set<Course> courseSet) {
		
		this.email = email;
		this.fullName = fullName;
		this.password = passowrd;
		this.courseSet = courseSet;
	}



	public Set<Course> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
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
		return password;
	}
	public void setPassowrd(String passowrd) {
		this.password = passowrd;
	}



	@Override
	public String toString() {
		return "Email: " + email + " | fullName: " + fullName + " | passowrd: " + password +" | Course set: "+courseSet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseSet, email, fullName, password);
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
		return Objects.equals(courseSet, other.courseSet) && Objects.equals(email, other.email)
				&& Objects.equals(fullName, other.fullName)
				&& Objects.equals(password, other.password);
	}



	
	
}
