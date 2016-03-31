import android.util.Log;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Bdub on 3/6/16.
 */
public class TestsForLocationJDBCTemplate extends JDBCTemplate implements AppVars
{
    Location l;

    @Test
    @Override
    public void testCreate()
    {
        super.testCreate();

        Number id;
        String returned;

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        LocationJDBCTemplate locationJDBCTemplate = (LocationJDBCTemplate) context
                .getBean("locationJDBCTemplate");

        l = createTestLocation();

        id = locationJDBCTemplate.create(l.getStreetNumber(), l.getStreetName(),
                l.getCity(), l.getState(), l.getZip());

        l.setId(id.intValue());

        returned = locationJDBCTemplate.getLocation(id.intValue()).toString();

        assertTrue(returned.equals(l.toString()));

        locationJDBCTemplate.delete(id);
    }

    @Test
    @Override
    public void testGet()
    {
        super.testGet();
        Number id = 2;
        Location location;

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        LocationJDBCTemplate locationJDBCTemplate = (LocationJDBCTemplate) context
                .getBean("locationJDBCTemplate");

        l = createTestLocation();
        locationJDBCTemplate.create(l.getStreetNumber(), l.getStreetName(),
                l.getCity(), l.getState(), l.getZip());

        location = locationJDBCTemplate.getLocation(id.intValue());

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

    private Location createTestLocation()
    {
        Location location = new Location();

        location.setStreetNumber(1);
        location.setStreetName("streetName");
        location.setCity("city");
        location.setState("state");
        location.setZip(1);

        return location;
    }
}


