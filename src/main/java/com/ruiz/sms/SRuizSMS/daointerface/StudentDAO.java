package com.ruiz.sms.SRuizSMS.daointerface;

import java.util.List;

import com.ruiz.sms.SRuizSMS.model.Course;
import com.ruiz.sms.SRuizSMS.model.Student;

public interface StudentDAO {
	
	List<Student>getAllStudents();

	Student getStudentByEmail(String email);

	void validateStudent(String email, String password);

	void registerStudentToCourse(Student student);

	List<Course>getStudentCourses(String email);
}
