package com.codecracker.session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionAttributeServlet extends HttpServlet {

    public static final String SESSION_ATTRIBUTE = "SESSION_ATTRIBUTE";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        req.getSession().setAttribute(SESSION_ATTRIBUTE,"Session argument");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dispatched");
        requestDispatcher.forward(req,resp);
    }


}
