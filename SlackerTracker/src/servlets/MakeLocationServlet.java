package servlets;

import controllers.LocationJDBCTemplate;
import entities.AppVars;
import entities.Location;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bdub on 4/2/16.
 */

@WebServlet(
        name = "makeLocationServlet",
        urlPatterns = "/make-loc"
)
public class MakeLocationServlet extends HttpServlet implements AppVars
{
    private static Logger log = Logger.getLogger("servlets.MakeLocationServlet");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        Location loc = new Location();
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        LocationJDBCTemplate jdbc = (LocationJDBCTemplate) context.getBean
                ("locationJDBCTemplate");

        List<Location> locations = new ArrayList<>();

        int id;

        String streetNumber;
        String streetName;
        String city;
        String state;
        String zip;

        streetNumber = req.getParameter("streetNumber");
        streetName = req.getParameter("streetName");
        city = req.getParameter("city");
        state = req.getParameter("state");
        zip = req.getParameter("zip");

        loc.setStreetNumber(Integer.parseInt(streetNumber));
        loc.setStreetName(streetName);
        loc.setCity(city);
        loc.setState(state);
        loc.setZip(Integer.parseInt(zip));

        id = (jdbc.create(loc));

        HttpSession session = req.getSession();

        locations = jdbc.getAllLocations();

        session.setAttribute("locations", locations);

        resp.sendRedirect("index.jsp");
    }
}
