import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Bdub on 3/6/16.
 */
public abstract class JDBCTemplate
{
    static final Logger log = Logger.getLogger("TestsForLocation");

    public void testCreate()
    {
        log.setLevel(Level.TRACE);
    }

    public void testGet() { log.setLevel(Level.TRACE);}

    public void testDelete()
    {
        log.setLevel(Level.TRACE);
    }

    public void testFindAll()
    {
        log.setLevel(Level.TRACE);
    }

    public void update()
    {
        log.setLevel(Level.TRACE);
    }
}
