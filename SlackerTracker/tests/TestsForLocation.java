import persistence.LocationJDBCTemplate;
import entities.Location;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Bdub on 3/6/16.
 */
public class TestsForLocation extends JDBCTemplate
{
    private static final Logger log = Logger.getLogger("TestsForLocation");

    //classes
    private Location loc;
    private LocationJDBCTemplate jdbc;

    //vars
    private Integer id;
    private Integer streetNumber;
    private String streetName;
    private String city;
    private String state;
    private Integer zip;

    @Before
    public void init()
    {
        loc = new Location();
        jdbc = new LocationJDBCTemplate();

        id = 1;
        streetNumber = 2;
        streetName = "streetName";
        city = "city";
        state = "state";
        zip = 3;

        loc.setId(id);
        loc.setStreetNumber(streetNumber);
        loc.setStreetName(streetName);
        loc.setCity(city);
        loc.setState(state);
        loc.setZip(zip);
    }

    @Test
    public void testToString()
    {
        String str;
        String returned;

        str = "id: " + id + ", streetNumber: " + streetNumber + ", streetName: " +
                streetName + ", city: " + city + ", state: " + state + ", zip: " + zip;


        returned = loc.toString();

        assertTrue(str.equals(returned));
    }
}
