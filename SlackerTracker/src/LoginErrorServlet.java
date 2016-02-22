///**
// * Created by Bdub on 2/20/16.
// */
//
//import javax.imageio.IIOException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet
//        (
//                name = "loginErrorServlet",
//                urlPatterns = {"/loginError"}
//        )
//
//public class LoginErrorServlet extends HttpServlet
//{
//    public void doGet (HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IIOException
//    {
//        String url = "/login-error.jsp";
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//
//        try
//        {
//            dispatcher.forward(request, response);
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//}
