package com.ruiz.sms.SRuizSMS.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.ruiz.sms.SRuizSMS.daointerface.CourseDAO;
import com.ruiz.sms.SRuizSMS.daointerface.StudentDAO;
import com.ruiz.sms.SRuizSMS.model.Course;
import com.ruiz.sms.SRuizSMS.model.Student;
import com.ruiz.sms.SRuizSMS.util.SMSUtil;

public class StudentDAOImpl extends SMSUtil implements StudentDAO{

	private String email;
	private String password;
	CourseDAO qry = new CourseDAOImpl();
	Scanner input = new Scanner(System.in);
	@Override
	public List<Student> getAllStudents() {
		Session session = SMSUtil.getConnection();
		String hql = "FROM Student";
		TypedQuery<Student> qry = session.createQuery(hql,Student.class);
		List<Student> studentResults = qry.getResultList();
		
		for(Student s: studentResults) {
			System.out.println("Student id: "+s.getId()+" Student Name: "+s.getFullName());
		}
		session.close();
		return studentResults;
	}

	@Override
	public Student getStudentByEmail(String email) {
		Session session = SMSUtil.getConnection();
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
		Session session = SMSUtil.getConnection();
		String hql = "FROM Student WHERE email = :email";
		TypedQuery<Student> qry = session.createQuery(hql,Student.class);
		qry.setParameter("email", email);
		Student student = qry.getSingleResult();
		
		if(student.getEmail().equals(email) && student.getPassowrd().equals(password)) {
			getAllStudents();
			runStudentMenu();
		}else {
			System.out.println("Invalid email or password. Please try again");
			email=input.nextLine();
			password = input.nextLine();
			validateStudent(email,password);
		}
		
	}
	public void runStudentMenu() {
		int selection =0;
		System.out.println("\n Welcome, please make a selection");
		
		while(true) {
			System.out.println("Student Menu");
			System.out.println("------------");
			System.out.println("1. Login");
			System.out.println("2. List Student with email");
			System.out.println("3. List all available courses");
			System.out.println("4. Logout");
			
			selection = input.nextInt();
			
			switch(selection) {
			case 1: login();
					continue;
			case 2: System.out.print("Enter email: ");
					String email = input.nextLine();
					getStudentByEmail(email);
					continue;
			case 3: qry.getAllCourses();
			case 4: logout();
			
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
	public void registerStudentToCourse(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		Session session = SMSUtil.getConnection();
		String hql = "SELECT c.Name FROM Course c";
		return null;
	}

}
