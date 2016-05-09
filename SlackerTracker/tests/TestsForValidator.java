import org.apache.log4j.Logger;
import org.junit.Test;
import util.Validator;

import java.util.ArrayList;

/**
 * Created by Bdub on 5/8/16.
 */
public class TestsForValidator
{
    private static final Logger log = Logger.getLogger("TestsForLocation");

    @Test
    public void testIsEmpty()
    {
        Validator val;
        ArrayList<String> inputs;

        inputs = new ArrayList<String>() {{add("0"); add("1"); add("2"); add("3"); add("4"); add(""); add(null);}};

        val = new Validator();

        log.debug(val.isEmpty(inputs));
    }
}
