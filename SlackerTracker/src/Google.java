import android.util.Log;
import com.google.maps.GeoApiContext;
import com.sun.xml.internal.txw2.Document;
import org.apache.log4j.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Bdub on 2/19/16.
 */
public class Google
{
    private static final String GOOGLE_API_KEY = "AIzaSyBKXLe2ChocA8-es3OiIGlKcPnFtELUBH4\t\n";

    public static void main(String[] args)
    {
        //get context
        GeoApiContext geoApiContext = new GeoApiContext();
        //server key
        geoApiContext.setApiKey(GOOGLE_API_KEY);

        //test addresses
        String origin = "Madison";
        String destination = "Milwaukee";
        String urlString = "http://maps.googleapis.com/maps/api/directions/json?sensor=false&origin="+origin+"&destination="+destination;

        try
        {
            URL googleService = new URL(urlString);

            HttpURLConnection googleConnection = (HttpURLConnection) googleService.openConnection();

            googleConnection.setAllowUserInteraction(false);
            googleConnection.setDoInput(true);
            googleConnection.setDoOutput(false);
            googleConnection.setUseCaches(true);
            googleConnection.setRequestMethod("GET");
            googleConnection.connect();

            DocumentBuilderFactory factoryDir = DocumentBuilderFactory.newInstance();
            DocumentBuilder parseDirInfo = factoryDir.newDocumentBuilder();
            org.w3c.dom.Document docDir = parseDirInfo.parse(googleConnection.getInputStream());

            googleConnection.disconnect();
            String result = docDir.toString();

            System.out.println(result);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
