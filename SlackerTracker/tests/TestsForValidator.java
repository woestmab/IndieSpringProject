import entities.Appointment;
import entities.Location;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import util.Validator;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bdub on 5/8/16.
 */
public class TestsForValidator
{
    private static final Logger log = Logger.getLogger("TestsForLocation");
    private static Appointment appt;
    private static Location loc;
    private static Validator validator;

    @Before
    public void init()
    {
        validator = new Validator();
        appt = new Appointment();
        loc = new Location();

        appt.setId(1);
        appt.setLocationsId(2);
        appt.setTitle("title");
        appt.setUrl("url");
        appt.setApptClass("apptClass");
        appt.setStart(1);
        appt.setEnd(9);
        appt.setDate("2016-05-10");

        loc.setId(1);
        loc.setStreetNumber(1);
        loc.setStreetName("streetName");
        loc.setCity("city");
        loc.setState("state");
        loc.setZip(11111);
    }

    @Test
    public void testForValidate()
    {
        assertTrue(validator.validForm(appt));
        assertTrue(validator.validForm(loc));
    }

    @Test
    public void testIsEmpty()
    {
        Validator val;
        ArrayList<String> inputs;

        inputs = new ArrayList<String>() {{add("0"); add("1"); add("2"); add("3"); add("4"); add(""); add(null);}};

        val = new Validator();

        assertTrue(val.isEmpty(inputs));
    }

    @Test
    public void testValidString()
    {
        assertTrue(validator.validString(appt.getTitle()));
    }

    @Test
    public void testValidTime()
    {
        assertTrue(validator.validTime(appt.getStart()));
    }

    @Test
    public void testValidDate()
    {
        assertTrue(validator.validDate(appt.getDate()));
    }
}
