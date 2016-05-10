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
    private static AppointmentJDBCTemplate jdbc;

    @Before
    public void init()
    {
        context = new ClassPathXmlApplicationContext
            ("Beans.xml");
        jdbc = (AppointmentJDBCTemplate) context.getBean
            ("appointmentJDBCTemplate");
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

        jdbc.insert(appt);
        List<Appointment> appts = jdbc.getAllAppointments();

        assertTrue(appts.size() > 0);
    }

    @Test
    public void testSelectAll()
    {

    }

    @Test
    public void testGetAppointmentsByDate()
    {
        String date;
        List results;
        date = "2016-05-10";

        results = jdbc.getApptsByDate(date);
    }
}
