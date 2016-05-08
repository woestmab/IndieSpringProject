package servlets;

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
        LocationJDBCTemplate jdbc;
        Validator val;

        loc = new Location();
        appt = new Appointment();
        converter = new VarConverter();
        context = new ClassPathXmlApplicationContext("Beans.xml");
        jdbc = (LocationJDBCTemplate) context.getBean("locationJDBCTemplate");
        val = new Validator();

        ArrayList<String> inputs = new ArrayList<>();

        String streetNumber;
        String streetName;
        String city;
        String state;
        String zip;

        String title;
        String startTime;
        String endTime;
        String date;

        streetNumber = request.getParameter("streetNumber");
        streetName = request.getParameter("streetName");
        city = request.getParameter("city");
        state = request.getParameter("state");
        zip = request.getParameter("zip");

        title = request.getParameter("title");
        startTime = request.getParameter("startTime");
        endTime = request.getParameter("endTime");
        date = request.getParameter("date");

        inputs.add(streetNumber);
        inputs.add(streetName);
        inputs.add(city);
        inputs.add(state);
        inputs.add(zip);

        inputs.add(title);
        inputs.add(startTime);
        inputs.add(endTime);
        inputs.add(date);

        if (!val.isEmpty(inputs))
        {
            loc.setStreetNumber(Integer.parseInt(streetNumber));
            loc.setStreetName(streetName);
            loc.setCity(city);
            loc.setState(state);
            loc.setZip(Integer.parseInt(zip));

            appt.setTitle(title);
            appt.setStart(Long.valueOf(startTime));
            appt.setStart(Long.valueOf(endTime));
            appt.setDate(date);
        }

//

        //loc.setId(jdbc.create(loc));

        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }
}
