# spring-session-issue
Sample project to replicate spring session issue

Running project:
This project can be run on ebmedded jetty server by invocing run-jetty.bat
Below are app urls
http://localhost:8083/add
http://localhost:8083/view
http://localhost:8083/error

Add session attribute and forward to url which will result in 404.
On 404 error servlet gets called but not have access to session created in Add call.

Add servlet code:
```java
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
```

View servlet code:
```java
public class ViewSessionAttribute extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        HttpSession httpSession = req.getSession(false);
        String value = null;
        if (httpSession!=null){
            value = httpSession.getAttribute(SessionAttributeServlet.SESSION_ATTRIBUTE)+":: class ::"+httpSession.getClass()
            +":: "+httpSession.getId();
        }
        resp.getWriter().println("Session details -> "+value);
    }
}
```

Error servlet code:
```java
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
```

Session details can be found by calling view or error directly.
Demo
![](/images/add.PNG)
![](/images/view.PNG)
![](/images/error.PNG)

