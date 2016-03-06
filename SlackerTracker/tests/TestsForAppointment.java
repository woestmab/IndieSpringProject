/**
 * Created by Bdub on 3/5/16.
 */

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestsForAppointment
{
    public static final Logger log = Logger.getLogger("slackerTracker");

    /**
     * Test to string.
     */

    @Test
    public void testToString()
    {
        log.setLevel(Level.INFO);
        String returned;
        String testString;

        int id = 1;
        int locationId = 1;
        String title = "title";
        String url = "url";
        String aptClass = "aptClass";
        String start = "12345678901234567890";
        String end = "12345678901234567890";

        Appointment appt = new Appointment();

        appt.setId(id);
        appt.setLocationsId(locationId);
        appt.setTitle(title);
        appt.setUrl(url);
        appt.setApptClass(aptClass);
        appt.setStart(start);
        appt.setEnd(end);

        testString = "id: " + id + ", locationId: " + locationId + ", title: " + title +
            ", url: " + url + ", apptClass: " + aptClass + ", start: " + start + ", " +
                "end:" +
            " " + end;

        returned = appt.toString();

        log.info("testString: " + testString);
        log.info("returned:   " + returned);

        assertTrue(testString.equals(returned));
    }
}