package servlets;

import org.springframework.jdbc.core.JdbcTemplate;
import persistence.AppointmentJDBCTemplate;
import persistence.LocationJDBCTemplate;
import util.Validator;
import util.VarConverter;
import entities.Appointment;
import entities.Location;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Bdub on 4/2/16.
 */

@WebServlet(
        name = "make-appt",
        urlPatterns = "/make-appt"
)

public class MakeAppointmentServlet extends HttpServlet
{
    private static Logger log = Logger.getLogger("servlets.MakeLocationServlet");

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

        loc = new Location();
        appt = new Appointment();
        converter = new VarConverter();
        context = new ClassPathXmlApplicationContext("Beans.xml");
        locJDBC = (LocationJDBCTemplate) context.getBean("locationJDBCTemplate");
        apptJDBC = (AppointmentJDBCTemplate) context.getBean("appointmentJDBCTemplate");
        val = new Validator();

        inputs = new ArrayList<>();

        String streetNumber = request.getParameter("streetNumber");
        String streetName = request.getParameter("streetName");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        String title = request.getParameter("title");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String date = request.getParameter("date");

        inputs.add(streetNumber);
        inputs.add(streetName);
        inputs.add(city);
        inputs.add(state);
        inputs.add(zip);

        inputs.add(title);
        inputs.add(startTime);
        inputs.add(endTime);
        inputs.add(date);

        if (val.isEmpty(inputs))
        {
            log.debug("not empty");
            loc.setStreetNumber(Integer.parseInt(streetNumber));
            loc.setStreetName(streetName);
            loc.setCity(city);
            loc.setState(state);
            loc.setZip(Integer.parseInt(zip));

            appt.setTitle(title);
            appt.setStart(converter.stringToTimeInMs(startTime, date));
            appt.setEnd(converter.stringToTimeInMs(endTime, date));
            appt.setDate(date);

            loc.setId(locJDBC.insert(loc));
            appt.setLocationsId(loc.getId());
            apptJDBC.insert(appt);
        }

        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }
}
