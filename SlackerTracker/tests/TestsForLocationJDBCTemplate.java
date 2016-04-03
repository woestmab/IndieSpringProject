import android.util.Log;
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

        id = jdbc.create(loc);

        loc.setId(id.intValue());

        returned = jdbc.getLocation(id.intValue()).toString();

        assertTrue(returned.equals(loc.toString()));

        jdbc.delete(id);
    }

    @Test
    @Override
    public void testGet()
    {
        super.testGet();
        Number id = 28;
        Location location;

        jdbc.create(loc);

        location = jdbc.getLocation(id.intValue());

        assertTrue(location != null);
    }

    @Test
    @Override
    public void testDelete()
    {
        super.testDelete();

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


