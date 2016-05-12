package servlets;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controllers.DailyRouteController;
import controllers.GoogleDirectionsController;
import entities.Appointment;
import entities.Location;
import entities.Route;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import persistence.AppointmentJDBCTemplate;
import persistence.LocationJDBCTemplate;
import util.Validator;
import util.VarConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Bdub on 5/8/16.
 */

@WebServlet(
        name = "getApptsServlet",
        urlPatterns = "/get-appts"
)

public class GetRecordsServlet extends HttpServlet
{
    private static Logger log = Logger.getLogger("servlets.GetRecords");

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Validator val = new Validator();
        PrintWriter out;
        String date;
        String id;
        Gson gson;

        id = request.getParameter("id");
        date = request.getParameter("date");
        log.debug(date);

        if (date == null && id == null)
        {
            ApplicationContext context;
            AppointmentJDBCTemplate apptJDBC;
            ArrayList<Appointment> appointments;
            String json;

            context = new ClassPathXmlApplicationContext("Beans.xml");
            apptJDBC = (AppointmentJDBCTemplate) context.getBean("appointmentJDBCTemplate");
            out = response.getWriter();

            appointments = (ArrayList<Appointment>) apptJDBC.getAllAppointments();

            gson = new GsonBuilder()
                    .disableHtmlEscaping()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();

            json = "{\n\"success\": 1,\n\"result\": ";
            json += gson.toJson(appointments);
            json += "}";

            response.setContentType("application/json");
            out.print(json);
            out.flush();
        }
        else if (date != null && val.validDate(date))
        {
            DailyRouteController drc;
            ArrayList<ArrayList<Route>> trips;
            String json;

            drc = new DailyRouteController();
            drc.createRoute(date);
            gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setPrettyPrinting()
                .serializeNulls()
                .create();

            trips = drc.getTrips();
            json = gson.toJson(trips);

            out = response.getWriter();
            out.print(json);
            out.flush();
        }
        else if (id != null)
        {
            ApplicationContext context;
            AppointmentJDBCTemplate apptJDBC;
            LocationJDBCTemplate locJDBC;
            Appointment appt;
            Location loc;
            String apptJson;
            String locJson;
            String json;

            context = new ClassPathXmlApplicationContext("Beans.xml");
            apptJDBC = (AppointmentJDBCTemplate) context.getBean("appointmentJDBCTemplate");
            locJDBC = (LocationJDBCTemplate) context.getBean("locationJDBCTemplate");
            out = response.getWriter();

            appt = apptJDBC.getAppointment(Integer.parseInt(id));
            loc = locJDBC.getLocation(appt.getLocationsId());

            gson = new GsonBuilder()
                    .disableHtmlEscaping()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();

            apptJson = gson.toJson(appt);
            locJson = gson.toJson(loc);

            json = "[" + apptJson + "," + locJson + "]";

            response.setContentType("application/json");
            out.print(json);
            out.flush();
        }
    }
}
