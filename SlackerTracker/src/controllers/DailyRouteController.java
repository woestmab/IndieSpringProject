package controllers;

import entities.Appointment;
import entities.Location;
import entities.Route;
import entities.Step;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.AppointmentJDBCTemplate;
import persistence.LocationJDBCTemplate;

import java.util.*;

/**
 * Created by Bdub on 5/10/16.
 */
public class DailyRouteController
{
    private static final Logger log = Logger.getLogger("slackerTracker");
    private static ApplicationContext context = new ClassPathXmlApplicationContext
            ("Beans.xml");
    private static AppointmentJDBCTemplate apptJDBC = (AppointmentJDBCTemplate) context.getBean
            ("appointmentJDBCTemplate");
    private static LocationJDBCTemplate locJDBC = (LocationJDBCTemplate) context.getBean
            ("locationJDBCTemplate");

    private ArrayList<Appointment> appts;
    private ArrayList<Location> locs;
    private ArrayList<ArrayList<Route>> trips;

    public ArrayList<ArrayList<Route>> getTrips()
    {
        return trips;
    }

    public String createRoute(String date)
    {
        retrieveData(date);
        queryGoogleTransit();
        return null;
    }

    private void retrieveData(String date)
    {
        appts = new ArrayList<>();
        appts.add(new Appointment());
        appts.get(0).setLocation(locJDBC.getLocation(103));
        appts = (ArrayList<Appointment>) apptJDBC.getApptsByDate(date);
        locs = new ArrayList<>();

        for (Appointment a : appts)
        {
            a.setLocation(locJDBC.getLocation(a.getLocationsId()));
        }
    }

    private void queryGoogleTransit()
    {
        Location home = locJDBC.getLocation(103);
        trips = new ArrayList<>();
        GoogleDirectionsController gdc = new GoogleDirectionsController();

        for (int i = 0; i < appts.size(); i++)
        {
            if (i == 0)
            {
                trips.add(gdc.parseRouteInfo(gdc.getRoute(home, appts.get(i).getLocation(),
                        appts.get(i), false)));
                log.debug(trips.toString());
            }
            else if ((i <= appts.size() - 1) &&
                    (appts.get(i).getLocation().getId() != appts.get(i - 1).getLocation().getId()))
            {
                ArrayList<Route> tempTrip = gdc.parseRouteInfo(gdc.getRoute(appts.get(i-1).getLocation(),
                        appts.get(i).getLocation(), appts.get(i), false));

                if (tempTrip.size() > 0)
                {
                    trips.add(tempTrip);
                }
            }
        }
        trips.add(gdc.parseRouteInfo(gdc.getRoute(appts.get(appts.size()-1).getLocation(),
                home, appts.get(appts.size()-1), true)));
        log.debug("trips " + trips.toString());
    }
}
