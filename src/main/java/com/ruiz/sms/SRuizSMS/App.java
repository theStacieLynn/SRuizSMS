package com.ruiz.sms.SRuizSMS;

import com.ruiz.sms.SRuizSMS.daointerface.StudentDAO;
import com.ruiz.sms.SRuizSMS.service.StudentDAOImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentDAO student = new StudentDAOImpl();
        StudentDAOImpl st = new StudentDAOImpl();
        
        
        st.login();
    }
}
