import entities.Appointment;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.AppointmentJDBCTemplate;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by Bdub on 3/5/16.
 */


public class TestsForAppointmentJDBC
{
    private static final Logger log = Logger.getLogger("slackerTracker");
    private static ApplicationContext context;
    private static AppointmentJDBCTemplate appointmentJDBCTemplate;

    @Before
    public void init()
    {

    }

    @Test
    public void testCreateRecord()
    {
        log.setLevel(Level.DEBUG);

        Appointment appt;

        int location = 103;
        String title = "title";
        String url = "url";
        String apptClass = "apptClass";
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();

        appt = new Appointment();

        appt.setLocationsId(location);
        appt.setTitle(title);
        appt.setUrl(url);
        appt.setApptClass(apptClass);
        appt.setStart(start);
        appt.setEnd(end);

        ApplicationContext context = new ClassPathXmlApplicationContext
                ("Beans.xml");
        AppointmentJDBCTemplate appointmentJDBCTemplate = (AppointmentJDBCTemplate) context.getBean
                ("appointmentJDBCTemplate");

        appointmentJDBCTemplate.insert(appt);
        List<Appointment> appts = appointmentJDBCTemplate.getAllAppointments();

        assertTrue(appts.size() > 0);
    }

    @Test
    public void testSelectAll()
    {

    }
}
