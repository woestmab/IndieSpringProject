import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Bdub on 3/6/16.
 */
public abstract class JDBCTemplate
{
    Logger log = Logger.getLogger("TestsForLocation");

    public void testCreate()
    {
        log.setLevel(Level.DEBUG);
    }

    public void testGet() { log.setLevel(Level.DEBUG);}

    public void testDelete()
    {
        log.setLevel(Level.DEBUG);
    }

    public void testFindAll()
    {
        log.setLevel(Level.DEBUG);
    }

    public void update()
    {
        log.setLevel(Level.DEBUG);
    }
}
