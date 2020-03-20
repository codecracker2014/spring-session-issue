package com.codecracker.session;

import org.springframework.session.MapSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.web.http.SessionRepositoryFilter;

import javax.servlet.*;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class CustomFIlter implements Filter {

    private SessionRepositoryFilter sessionRepositoryFilter
            = new SessionRepositoryFilter(new MapSessionRepository(new ConcurrentHashMap<String, Session>()));

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        sessionRepositoryFilter.doFilter(request, response,chain);
    }

    public void destroy() {

    }
}
