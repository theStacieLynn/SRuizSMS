package com.ruiz.sms.SRuizSMS.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SMSUtil {
	/**
	 * rdbms connection
	 * @return
	 */
	public static Session getConnection() {
		SessionFactory fc = new Configuration().configure().buildSessionFactory();
		Session session = fc.openSession();
		return session;
	}
}
