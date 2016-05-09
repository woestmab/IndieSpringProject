import persistence.LocationJDBCTemplate;
import interfaces.AppVars;
import entities.Location;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Bdub on 3/6/16.
 */
public class TestsForLocationJDBCTemplate extends JDBCTemplate implements AppVars
{
    private ApplicationContext context;
    private LocationJDBCTemplate jdbc;
    private Location loc;

    @Before
    public void createTestLocation()
    {
        loc = new Location();
        context = new ClassPathXmlApplicationContext("Beans.xml");

        jdbc = (LocationJDBCTemplate) context.getBean("locationJDBCTemplate");

        loc.setStreetNumber(1);
        loc.setStreetName("streetName");
        loc.setCity("city");
        loc.setState("state");
        loc.setZip(1);
    }

    @Test
    @Override
    public void testCreate()
    {
        super.testCreate();

        Number id;
        String returned;

        id = jdbc.insert(loc);
        loc.setId(id.intValue());

        returned = jdbc.getLocation(id.intValue()).toString();

        log.debug(TAG + loc.toString());
        log.debug(TAG + returned);

        assertTrue(returned.equals(loc.toString()));

        jdbc.deleteLocation(id);
    }

    @Test
    @Override
    public void testGet()
    {
        super.testGet();
        Number id = 40;
        Location result;
        Location location;

        jdbc.insert(loc);

        result = jdbc.getLocation(id.intValue());

        assertTrue(result != null);
    }

    @Test
    @Override
    public void testDelete()
    {
        super.testDelete();

        Location result;
        int id = jdbc.insert(loc);

        loc.setId(id);
        jdbc.deleteLocation(id);

        result = jdbc.getLocation(id);

        assertTrue(result == null);
    }

    @Test
    @Override
    public void testFindAll()
    {
        super.testFindAll();
    }

    @Test
    @Override
    public void update()
    {
        super.update();
    }
}


