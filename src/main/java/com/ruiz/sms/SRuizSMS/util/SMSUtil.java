package com.ruiz.sms.SRuizSMS.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SMSUtil {
	/**
	 * rdbms connection
	 * @return
	 */
	static SessionFactory fc = null;
	public static Session getConnection() {
		try {
			fc = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		Session session = fc.openSession();
		return session;
	}
}
