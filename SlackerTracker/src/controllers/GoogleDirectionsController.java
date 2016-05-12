package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import entities.*;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Bdub on 2/19/16.
 */
public class GoogleDirectionsController
{
    private Singleton singleton;
    private static final Logger log = Logger.getLogger("controllers.GoogleDirectionsController");

    private String googleApiKey;
    private String userAgent;
    private String googleDirectionsUrl;

    public GoogleDirectionsController(){
        singleton = Singleton.getInstance();
    }

    public ArrayList<Step> getRoute(Location origin, Location dest, Appointment appt, boolean lastTrip)
    {
        googleApiKey = singleton.getProperties().getProperty("google.api.key");
        userAgent = singleton.getProperties().getProperty("user.agent");
        googleDirectionsUrl = singleton.getProperties().getProperty("google.directions.url");

        String originString;
        String destinationString;
        String travelTime;
        String url;
        String mode = "transit";

        //get context
        GeoApiContext geoApiContext = new GeoApiContext();
        Gson gson = new GsonBuilder().create();

        //server key
        geoApiContext.setApiKey(googleApiKey);

        originString = origin.getStreetNumber() + "+" + origin.getStreetName() + "+" +
                origin.getCity() + "+" + origin.getState() + "+" + origin.getZip();

        destinationString = dest.getStreetNumber() + "+" + dest.getStreetName() + "+" +
                dest.getCity() + "+" + dest.getState() + "+" + dest.getZip();

        originString = originString.replace(" ", "+");
        destinationString = destinationString.replace(" ", "+");

        if (lastTrip)
        {
            travelTime = "&departure_time=" + Long.toString(appt.getEnd()/1000);
        }
        else
        {
            travelTime = "&arrival_time=" + Long.toString(appt.getStart()/1000);
        }

        url = googleDirectionsUrl + originString
                + "&destination=" + destinationString + travelTime +
                "&mode=" + mode;

        try
        {
            URL obj = new URL(url);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", userAgent);

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
            return steps;
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Route> parseRouteInfo(ArrayList<Step> steps)
    {
        ArrayList<Route> routes = new ArrayList<>();

        for (Step s : steps)
        {
            if (s.getTravelMode().equals("TRANSIT"))
            {
                Route r = new Route();
                r.setDepartureStop(s.getHtmlInstructions());
                r.setBusNumber(s.getTransitDetails().line.short_name);
                r.setArrivalTime(s.getTransitDetails().arrival_time.text);
                r.setArrivalStop(s.getTransitDetails().arrival_stop.name);
                r.setStopLocation(s.getTransitDetails().departure_stop.name);
                r.setDepartureTime(s.getTransitDetails().departure_time.text);
                routes.add(r);
            }
        }
        return routes;
    }
}
