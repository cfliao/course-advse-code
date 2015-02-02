package fcu.advse.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fcu.advse.layer.LogicLayer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private LogicLayer loginService = new LogicLayer();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("ID");
        String password = request.getParameter("password");
        
        System.out.println(id);
        System.out.println(password);
        boolean isSuccess = loginService.auth(id, password);
        if(isSuccess)
            response.sendRedirect("success.jsp");
        else
            response.sendRedirect("fail.jsp");
    }

}
