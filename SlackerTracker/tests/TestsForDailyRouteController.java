import controllers.DailyRouteController;
import entities.Appointment;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.AppointmentJDBCTemplate;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Bdub on 5/10/16.
 */
public class TestsForDailyRouteController
{
    private static final Logger log = Logger.getLogger("slackerTracker");
    private static ApplicationContext context;
    private static AppointmentJDBCTemplate jdbc;
    private static DailyRouteController drc;

    @Before
    public void init()
    {
        context = new ClassPathXmlApplicationContext
                ("Beans.xml");
        jdbc = (AppointmentJDBCTemplate) context.getBean
                ("appointmentJDBCTemplate");
        drc = new DailyRouteController();
    }

    @Test
    public void testCreateRoute()
    {
        drc.createRoute("2016-05-12");
    }
}
