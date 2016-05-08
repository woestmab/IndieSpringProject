import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Appointment;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Bdub on 3/24/16.
 */
public class TestsForGson
{
    private final static Logger log = Logger.getLogger("Gson");

    @Test
    public void testAppointmentGsonBuilder()
    {
        Appointment appt = new Appointment();
        String gsonString =
                "{\n" +
                "  \"Id\": 1,\n" +
                "  \"LocationsId\": 1,\n" +
                "  \"Title\": \"title\",\n" +
                "  \"Url\": \"url\",\n" +
                "  \"ApptClass\": \"aptClass\",\n" +
                "  \"Start\": \"start\",\n" +
                "  \"End\": \"end\"\n" +
                "}";

        appt.setId(1);
        appt.setLocationsId(1);
        appt.setTitle("title");
        appt.setUrl("url");
        appt.setApptClass("aptClass");
        appt.setStart(1);
        appt.setEnd(2);

        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        log.info(gson.toJson(appt));

        assertTrue((gson.toJson(appt)).equals(gsonString));
    }
}
