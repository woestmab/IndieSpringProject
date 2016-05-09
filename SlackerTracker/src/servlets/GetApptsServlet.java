package servlets;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Appointment;
import entities.Location;
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

public class GetApptsServlet extends HttpServlet
{
    private static Logger log = Logger.getLogger("servlets.MakeLocationServlet");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ApplicationContext context;
        AppointmentJDBCTemplate apptJDBC;
        ArrayList<Appointment> appointments;
        Gson gson;
        String json;
        PrintWriter out;

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

        //response.sendRedirect("index.jsp");
    }
}
