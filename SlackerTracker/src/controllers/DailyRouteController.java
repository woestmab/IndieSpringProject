package controllers;

import entities.Appointment;
import entities.Location;
import entities.Route;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.AppointmentJDBCTemplate;
import persistence.LocationJDBCTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public String createRoute(String date)
    {
        retrieveData(date);
        queryGoogleTransit();
        return null;
    }

    private void retrieveData(String date)
    {
        appts = (ArrayList<Appointment>) apptJDBC.getApptsByDate(date);
        locs = new ArrayList<>();

        for (Appointment a : appts)
        {
            a.setLocation(locJDBC.getLocation(a.getLocationsId()));
        }
    }

    private void queryGoogleTransit()
    {
        Location start = locJDBC.getLocation(103);
        ArrayList<Route> routes;
        GoogleDirectionsController gdc = new GoogleDirectionsController();
        for (int i = 0; i < appts.size(); i++)
        {
            if (i == 0)
            {
                Appointment a = appts.get(i);
                routes = gdc.parseRouteInfo(gdc.getRoute(start, a.getLocation(), a));
            }
            else
            {
                routes = gdc.parseRouteInfo(gdc.getRoute(start, appts.get(i - 1).getLocation(), appts.get(i)));
                log.debug(routes.toString());
            }
        }
    }
}
