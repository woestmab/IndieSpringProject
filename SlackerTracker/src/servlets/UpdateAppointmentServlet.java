package servlets;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controllers.DailyRouteController;
import entities.Appointment;
import entities.Location;
import entities.Route;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import persistence.AppointmentJDBCTemplate;
import persistence.LocationJDBCTemplate;
import util.Validator;
import util.VarConverter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bdub on 5/11/16.
 */

@WebServlet(
        name = "updateApptServlet",
        urlPatterns = "/update-appt"
)

public class UpdateAppointmentServlet extends HttpServlet
{
    private static Logger log = Logger.getLogger("servlets.UpdateAppointmentServlet");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Location loc;
        Appointment appt;
        VarConverter converter;
        ApplicationContext context;
        Validator val;
        AppointmentJDBCTemplate apptJDBC;
        LocationJDBCTemplate locJDBC;
        ArrayList<String> inputs;
        List locResults;
        String error = null;
        String url;

        loc = new Location();
        appt = new Appointment();
        converter = new VarConverter();
        context = new ClassPathXmlApplicationContext("Beans.xml");
        locJDBC = (LocationJDBCTemplate) context.getBean("locationJDBCTemplate");
        apptJDBC = (AppointmentJDBCTemplate) context.getBean("appointmentJDBCTemplate");
        val = new Validator();

        inputs = new ArrayList<>();

        String streetNumber = request.getParameter("edit-streetNumber");
        String streetName = request.getParameter("edit-streetName");
        String city = request.getParameter("edit-city");
        String state = request.getParameter("edit-state");
        String zip = request.getParameter("edit-zip");

        String apptId = request.getParameter("edit-id");
        String title = request.getParameter("edit-title");
        String startTime = request.getParameter("edit-start");
        String endTime = request.getParameter("edit-end");
        String date = request.getParameter("edit-date");

        inputs.add(streetNumber);
        inputs.add(streetName);
        inputs.add(city);
        inputs.add(state);
        inputs.add(zip);

        inputs.add(title);
        inputs.add(startTime);
        inputs.add(endTime);
        inputs.add(date);

        while (true)
        {
            if (!val.isEmpty(inputs))
            {
                try
                {
                    loc.setStreetNumber(Integer.parseInt(streetNumber));
                } catch (NumberFormatException nfe)
                {
                    System.out.println("Problem parsing input string to Integer");
                    nfe.printStackTrace();

                    error = "There was a problem submitting your appointment.  " +
                            "Check your entries and try again.";
                    request.setAttribute("error", error);
                    break;
                }

                loc.setStreetName(streetName);
                loc.setCity(city);
                loc.setState(state);
                loc.setZip(Integer.parseInt(zip));

                appt.setId(Integer.parseInt(apptId));
                appt.setTitle(title);
                appt.setStart(converter.stringToTimeInMs(startTime, date));
                appt.setEnd(converter.stringToTimeInMs(endTime, date));
                appt.setDate(date);

                if (val.validForm(loc) && val.validForm(appt))
                {
                    locResults = locJDBC.getLocationId(loc);

                    if (locResults.isEmpty())
                    {
                        loc.setId(locJDBC.insert(loc));
                        appt.setLocationsId(loc.getId());
                        apptJDBC.updateAppointment(appt);
                    } else
                    {
                        appt.setLocationsId((Integer) locResults.get(0));
                        apptJDBC.updateAppointment(appt);
                    }
                }
            } else
            {
                error = "There was a problem submitting your appointment.  " +
                        "Check your entries and try again.";
                request.setAttribute("error", error);
            }
            break;
        }

        url = "/user-page.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
