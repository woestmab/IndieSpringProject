package servlets;

import controllers.LocationJDBCTemplate;
import entities.Appointment;
import entities.Location;
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
        name = "create-appt",
        urlPatterns = "/make-appt"
)

public class CreateAppointmentServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Location loc = new Location();
        Appointment appt = new Appointment();
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        LocationJDBCTemplate jdbc = (LocationJDBCTemplate) context.getBean
                ("locationJDBCTemplate");

        String streetNumber;
        String streetName;
        String city;
        String state;
        String zip;

        streetNumber = request.getParameter("streetNumber");
        streetName = request.getParameter("streetName");
        city = request.getParameter("city");
        state = request.getParameter("state");
        zip = request.getParameter("zip");

        loc.setStreetNumber(Integer.parseInt(streetNumber));
        loc.setStreetName(streetName);
        loc.setCity(city);
        loc.setState(state);
        loc.setZip(Integer.parseInt(zip));

        loc.setId(jdbc.create(loc));



        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
