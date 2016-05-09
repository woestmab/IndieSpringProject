import org.apache.log4j.Logger;
import entities.Appointment;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import util.VarConverter;

/**
 * Created by Bdub on 5/8/16.
 */
public class TestsForVarConverter
{
    private static final Logger log = Logger.getLogger("slackerTracker");

    @Test
    public void stringToTimeInMs()
    {
        VarConverter converter = new VarConverter();

        String date = "2016-05-10";
        String time = "10:20";

        converter.stringToTimeInMs(time, date);
    }
}
