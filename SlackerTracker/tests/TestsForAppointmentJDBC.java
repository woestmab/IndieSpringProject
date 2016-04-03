import dalvik.annotation.TestTargetClass;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by Bdub on 3/5/16.
 */


public class TestsForAppointmentJDBC
{
    private static final Logger log = Logger.getLogger("slackerTracker");

    //// TODO: 3/30/16 this won't work till locations are added to db

    @Test
    public void testCreateRecord()
    {
        log.setLevel(Level.DEBUG);

        int location = 40;
        String title = "title";
        String url = "url";
        String apptClass = "apptClass";
        String start = "12345678901234567890";
        String end = "12345678901234567890";

        ApplicationContext context = new ClassPathXmlApplicationContext
                ("Beans.xml");
        AppointmentJDBCTemplate appointmentJDBCTemplate = (AppointmentJDBCTemplate) context.getBean
                ("appointmentJDBCTemplate");

        appointmentJDBCTemplate.create(location, title, url, apptClass, start, end);
        List<Appointment> appts = appointmentJDBCTemplate.getAllAppointments();

        assertTrue(appts.size() > 0);
    }

    @Test
    public void testSelectAll()
    {

    }
}
