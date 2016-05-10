package controllers;

import entities.Appointment;
import entities.Location;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.AppointmentJDBCTemplate;
import persistence.LocationJDBCTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bdub on 5/10/16.
 */
public class DailyRouteController
{
    private static ApplicationContext context = new ClassPathXmlApplicationContext
            ("Beans.xml");
    private static AppointmentJDBCTemplate apptJDBC = (AppointmentJDBCTemplate) context.getBean
            ("appointmentJDBCTemplate");
    private static LocationJDBCTemplate locJDBC = (LocationJDBCTemplate) context.getBean
            ("locationJDBCTemplate");

    private ArrayList<Appointment> appts;
    private ArrayList<Location> locs;

    public String planSchedule(String date)
    {
        retrieveData(date);
        return null;
    }

    private void retrieveData(String date)
    {
        appts = (ArrayList<Appointment>) apptJDBC.getApptsByDate(date);
        locs = new ArrayList<>();

        for (Appointment a : appts)
        {
            locs.add(locJDBC.getLocation(a.getLocationsId()));
        }
    }

    private void queryGoogleTransit()
    {

    }
}
