package com.ruiz.sms.SRuizSMS.service;


import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.ruiz.sms.SRuizSMS.daointerface.CourseDAO;
import com.ruiz.sms.SRuizSMS.daointerface.StudentDAO;
import com.ruiz.sms.SRuizSMS.model.Course;
import com.ruiz.sms.SRuizSMS.model.Student;
import com.ruiz.sms.SRuizSMS.util.HibernateUtil;

public class StudentDAOImpl extends HibernateUtil implements StudentDAO{

	private String email;
	private String password;

	CourseDAO qry = new CourseDAOImpl();
	Scanner input = new Scanner(System.in);
	
	
	
	@Override
	public List<Student> getAllStudents() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Student";
		TypedQuery<Student> qry = session.createQuery(hql,Student.class);
		List<Student> studentResults = qry.getResultList();
		
		for(Student s: studentResults) {
			System.out.println(" Student Name: "+s.getFullName()+"Student email: "+s.getEmail());
		}
		session.close();
		return studentResults;
	}

	@Override
	public Student getStudentByEmail(String email) {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM Student WHERE email = :email";
		TypedQuery<Student> qry = session.createQuery(hql, Student.class);
		qry.setParameter("email", email);
		Student student = qry.getSingleResult();
		System.out.println("Student Name: "+student.getFullName()+" Student email: "+student.getEmail());
		session.close();
		return student;
		
	}

	@Override
	public void validateStudent(String email, String password) {
		Student student = this.getStudentByEmail(email);
		if(student.getEmail().equals(email) && student.getPassowrd().equals(password)) {
			//getStudentCourses(email);
			runStudentMenu();
		}else {
			System.out.println("Invalid email or password. Please try again");
			email=input.nextLine();
			password = input.nextLine();
			validateStudent(email,password);
		}
		
	}
	// need to change
	public void runStudentMenu() {
		int selection =0;
		System.out.println("\n Welcome, please make a selection");
		Student student = new Student();////Need to figure out
		while(true) {
			System.out.println("Student Menu");
			System.out.println("------------");
			System.out.println("1. Register to course");
			System.out.println("2. List all available courses");
			System.out.println("4. Logout");
			
			selection = input.nextInt();
			
			switch(selection) {
			case 1: System.out.println("Available Courses");
					qry.getAllCourses();
					System.out.println("Pleast enter course id you would like to add");
					int id = input.nextInt();
					registerStudentToCourse(student,id);
					continue;
			case 2: qry.getAllCourses();
			case 3: logout();
			
			}
			
		}
	}
	public void login() {
		System.out.println("Welcome to the login screen!");
		System.out.println("Enter email: ");
		email = input.nextLine();
	
		System.out.println("Enter password: ");
		password = input.nextLine();
		
		validateStudent(email, password);
	}
	
	public void logout() {
		System.out.println("You are now logged out");
		System.exit(0);
	}
	@Override
	public void registerStudentToCourse(Student student, int id) {
		Session session = HibernateUtil.getConnection();
		Set<Course> courseSet1 = new HashSet<Course>();
		String hql = "From Course Where id = :id";
		TypedQuery<Course> courseQry = session.createQuery(hql, Course.class);
		courseQry.setParameter("id", id);
		Course course = courseQry.getSingleResult();
		courseSet1.add(course);
		student.setCourseSet(courseSet1);
		session.save(student);
	
		
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		Session session = HibernateUtil.getConnection();
		String hql = "SELECT c.Name FROM Course c JOIN Student_Course sc ON c.id = sc.courseSet_id WHERE sc.Student_email=:email";
		TypedQuery<Course> qry = session.createQuery(hql,Course.class);
		qry.setParameter("email", email);
		List<Course> stCourses =qry.getResultList();
		for(Course c: stCourses) {
			System.out.println("Course ID: "+c.getId()+"Course Name: "+ c.getName()+" Instructor: "+c.getInstructor());
		}
		return stCourses;
	}

}
