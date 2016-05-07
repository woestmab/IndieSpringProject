package servlets;

import controllers.LocationJDBCTemplate;
import controllers.VarConverter;
import entities.Appointment;
import entities.Location;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        LocationJDBCTemplate jdbc;

        loc = new Location();
        appt = new Appointment();
        converter = new VarConverter();
        context = new ClassPathXmlApplicationContext("Beans.xml");
        jdbc = (LocationJDBCTemplate) context.getBean("locationJDBCTemplate");

//        location vars
        String streetNumber;
        String streetName;
        String city;
        String state;
        String zip;

//        appointment vars
        String startTime;
        String endTime;
        String date;

        streetNumber = request.getParameter("streetNumber");
        streetName = request.getParameter("streetName");
        city = request.getParameter("city");
        state = request.getParameter("state");
        zip = request.getParameter("zip");

        // TODO: 5/7/16 remove testing
        startTime = request.getParameter("startTime");
        endTime = request.getParameter("endTime");
        date = request.getParameter("date");

        log.debug("date" + converter.stringToLocalDate(date).toString());

        loc.setStreetNumber(Integer.parseInt(streetNumber));
        loc.setStreetName(streetName);
        loc.setCity(city);
        loc.setState(state);
        loc.setZip(Integer.parseInt(zip));

        //loc.setId(jdbc.create(loc));

        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
