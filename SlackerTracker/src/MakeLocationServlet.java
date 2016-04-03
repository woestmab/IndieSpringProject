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
        name = "makeLocationServlet",
        urlPatterns = "/make-loc"
)
public class MakeLocationServlet extends HttpServlet
{
    private static Logger log = Logger.getLogger("MakeLocationServlet");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doPost(req, resp);
        log.debug("doPost:");
    }
}
