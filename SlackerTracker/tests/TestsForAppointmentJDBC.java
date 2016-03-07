import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Bdub on 3/5/16.
 */


public class TestsForAppointmentJDBC
{
    private static final Logger log = Logger.getLogger("slackerTracker");

    @Test
    public void testCreateRecord()
    {
        log.setLevel(Level.DEBUG);

        String title = "title";
        String url = "url";
        String apptClass = "apptClass";
        String start = "12345678901234567890";
        String end = "12345678901234567890";

        ApplicationContext context = new ClassPathXmlApplicationContext
                ("Beans.xml");
        AppointmentJDBCTemplate appointmentJDBCTemplate = (AppointmentJDBCTemplate) context.getBean
                ("appointmentJDBCTemplate");

        appointmentJDBCTemplate.create(title, url, apptClass, start, end);
    }
}
