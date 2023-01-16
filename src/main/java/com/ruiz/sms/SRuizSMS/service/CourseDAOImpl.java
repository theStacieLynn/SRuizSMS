package com.ruiz.sms.SRuizSMS.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.ruiz.sms.SRuizSMS.daointerface.CourseDAO;
import com.ruiz.sms.SRuizSMS.model.Course;
import com.ruiz.sms.SRuizSMS.util.SMSUtil;

public class CourseDAOImpl extends SMSUtil implements CourseDAO{

	@Override
	public List<Course> getAllCourses() {
		Session session = SMSUtil.getConnection();
		String hql = "FROM Course";
		TypedQuery<Course> qry = session.createQuery(hql,Course.class);
		List<Course> courseResults = qry.getResultList();
		for(Course c: courseResults) {
			System.out.println(c.toString());
		}
		return courseResults;
	}

}
