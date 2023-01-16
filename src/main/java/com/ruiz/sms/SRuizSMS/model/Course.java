package com.ruiz.sms.SRuizSMS.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String instructor;
	
	
	
	
	/**
	 * empty course constructor
	 */
	public Course() {}
	
	/**
	 * constructor with parameters
	 * @param id
	 * @param name
	 * @param instructor
	 */
	public Course(int id, String name, String instructor) {
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}
	
	/**
	 * Getters and setters for class attributes:
	 * id, name(course name), instructor,(instructor name)
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course id:" + id + " | name:" + name + " | instructor:" + instructor;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id, instructor, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return id == other.id && Objects.equals(instructor, other.instructor) && Objects.equals(name, other.name);
	}
	
	
	
}
