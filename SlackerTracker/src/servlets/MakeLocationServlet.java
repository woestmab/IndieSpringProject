package servlets;

import interfaces.AppVars;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Bdub on 4/2/16.
 */

@WebServlet(
        name = "make-loc",
        urlPatterns = "/make-loc"
)
public class MakeLocationServlet extends HttpServlet implements AppVars
{
    private static Logger log = Logger.getLogger("servlets.MakeLocationServlet");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
    }
}
