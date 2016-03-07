import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Bdub on 3/6/16.
 */
public class TestsForLocation
{
    Logger log = Logger.getLogger("TestsForLocation");

    @Test
    public void testToString()
    {
        log.setLevel(Level.INFO);

        String str;
        String returned;

        Integer id = 1;
        Integer streetNumber = 2;
        String streetName = "streetName";
        String city = "city";
        String state = "state";
        Integer zip = 3;

        str = "id: " + id + ", streetNumber: " + streetNumber + ", streetName: " +
                streetName + ", city: " + city + ", state: " + state + ", zip: " + zip;

        Location location = new Location();

        location.setId(id);
        location.setStreetNumber(streetNumber);
        location.setStreetName(streetName);
        location.setCity(city);
        location.setState(state);
        location.setZip(zip);

        returned = location.toString();

        log.info(str);
        log.info(returned);

        assertTrue(str.equals(returned));
    }
}
