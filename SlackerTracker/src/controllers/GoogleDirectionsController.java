package controllers;

import com.google.common.base.CaseFormat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsStep;
import entities.GoogleDirectionsResult;
import entities.Step;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Bdub on 2/19/16.
 */
public class GoogleDirectionsController
{
    private static final Logger log = Logger.getLogger("controllers.GoogleDirectionsController");
    private static final String GOOGLE_API_KEY = "AIzaSyBKXLe2ChocA8-es3OiIGlKcPnFtELUBH4\t\n";
    private static final String USER_AGENT = "Mozilla/5.0";

    public void run()
    {
        //get context
        GeoApiContext geoApiContext = new GeoApiContext();
        Gson gson = new GsonBuilder().create();

        //server key
        geoApiContext.setApiKey(GOOGLE_API_KEY);

        //test addresses
        String origin = "26+RIDGEVIEW+COURT+MADISON+WI+53704";
        String destination = "1701+WRIGHT+STREET+MADISON+WI+53704";
        String mode = "transit";
        String arrivalTime = "1462555800";


        // TODO: 5/5/16 properties file
        String url = "http://maps.googleapis" +
                ".com/maps/api/directions/json?sensor=false&origin="+origin
                +"&destination="+destination + "&mode=" + mode + "&arrival_time=" +
                arrivalTime;

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

            GoogleDirectionsResult googleDirectionsResult = gson.fromJson(String.valueOf(response),
                    GoogleDirectionsResult.class);

            ArrayList<Step> steps = new ArrayList<>();

            for (GoogleDirectionsResult.Routes.Legs.Steps s : googleDirectionsResult.routes[0].legs[0].steps)
            {
                Step step = new Step();
                step.setTravelMode(s.travel_mode);
                step.setTransitDetails(s.transit_details);
                step.setHtmlInstructions(s.html_instructions);
                steps.add(step);
            }

            log.debug(googleDirectionsResult);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
