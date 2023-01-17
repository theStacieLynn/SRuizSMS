package com.ruiz.sms.SRuizSMS;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ruiz.sms.SRuizSMS.daointerface.StudentDAO;
import com.ruiz.sms.SRuizSMS.service.StudentDAOImpl;
import com.ruiz.sms.SRuizSMS.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {

	static Session session = HibernateUtil.getConnection();
	static Transaction t = session.beginTransaction();
    public static void main( String[] args )
    {
    	
    	t.commit();
        StudentDAO student = new StudentDAOImpl();
        StudentDAOImpl st = new StudentDAOImpl();
        
        
        st.login();
       
    }
}
