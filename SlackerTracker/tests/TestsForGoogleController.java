import controllers.GoogleController;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Bdub on 5/5/16.
 */
public class TestsForGoogleController
{
    private static final Logger log = Logger.getLogger("slackerTracker");

    @Test
    public void testRun()
    {
        GoogleController googleController = new GoogleController();
        googleController.run();
    }

}
