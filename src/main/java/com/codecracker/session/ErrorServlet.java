package com.codecracker.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ErrorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        HttpSession httpSession = req.getSession(false);
        String value = null;
        if (httpSession!=null){
            value = httpSession.getAttribute(SessionAttributeServlet.SESSION_ATTRIBUTE)+":: class ::"+httpSession.getClass()
                    +":: "+httpSession.getId();
        }
        resp.getWriter().println("Session details in error page -> "+value);
    }


}