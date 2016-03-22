import com.google.maps.GeoApiContext;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Bdub on 2/19/16.
 */
public class Google
{
    private static final Logger log = Logger.getLogger("Google");
    private static final String GOOGLE_API_KEY = "AIzaSyBKXLe2ChocA8-es3OiIGlKcPnFtELUBH4\t\n";
    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args)
    {
        //get context
        GeoApiContext geoApiContext = new GeoApiContext();
        //server key
        geoApiContext.setApiKey(GOOGLE_API_KEY);

        //test addresses
        String origin = "Madison";
        String destination = "Milwaukee";
        String url = "http://maps.googleapis" +
                ".com/maps/api/directions/json?sensor=false&origin="+origin+"&destination="+destination;

        try
        {
            URL obj = new URL(url);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            log.info("\nSending 'GET' request to URL: " + url);
            log.info("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con
                    .getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();
            log.info(response.toString());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
