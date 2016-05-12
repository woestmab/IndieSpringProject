package servlets;

/**
 * Created by Bdub on 2/20/16.
 */

import entities.Singleton;
import interfaces.AppVars;
import org.apache.log4j.Logger;

import javax.imageio.IIOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Index servlet.
 * this servlet is used to kick off the application and load the properties file
 */

@WebServlet
        (
                name = "slackerTracker",
                urlPatterns = {"/slackerTracker"}
        )

public class IndexServlet extends HttpServlet implements AppVars
{
    private static final Logger log = Logger.getLogger("slackerTracker");

    @Override
    public void init() throws ServletException
    {
        String propertiesPath;
        Singleton singleton;
        Properties properties;

        propertiesPath = "/slackerTracker.properties";
        singleton = Singleton.getInstance();
        properties = new Properties();

        try
        {
            properties.load(this.getClass().getResourceAsStream(propertiesPath));
            singleton.setProperties(properties);
        } catch (IOException ioe)
        {
            System.out.println("Unable to load properties file");
            ioe.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IIOException
    {
        String url = "/slackerTracker.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        try
        {
            dispatcher.forward(request, response);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
