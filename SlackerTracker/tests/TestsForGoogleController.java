import controllers.GoogleDirectionsController;
import entities.Appointment;
import entities.Location;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.AppointmentJDBCTemplate;
import persistence.LocationJDBCTemplate;

/**
 * Created by Bdub on 5/5/16.
 */
public class TestsForGoogleController
{
    private static final Logger log = Logger.getLogger("slackerTracker");
    private static GoogleDirectionsController gdc;

    private Appointment appt;
    private Location origin;
    private Location dest;

    @Before
    public void init()
    {
        gdc = new GoogleDirectionsController();
        appt = new Appointment();
        origin = new Location();
        dest = new Location();

        origin.setId(1);
        origin.setStreetNumber(26);
        origin.setStreetName("Ridgeview Court");
        origin.setCity("Madison");
        origin.setState("Wisconsin");
        origin.setZip(53704);

        origin.setId(2);
        dest.setStreetNumber(1701);
        dest.setStreetName("Wright Street");
        dest.setCity("Madison");
        dest.setState("Wisconsin");
        dest.setZip(53704);

        appt.setStart(1462894200000L);
    }

    @Test
    public void testRun()
    {
        gdc.run();
    }

    @Test
    public void testForGetRoute()
    {
        gdc.getRoute(origin, dest, appt);
    }

}
