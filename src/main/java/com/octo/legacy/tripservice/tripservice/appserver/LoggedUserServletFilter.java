package com.octo.legacy.tripservice.tripservice.appserver;

import com.octo.legacy.tripservice.tripservice.trip.TripDAO;
import com.octo.legacy.tripservice.tripservice.user.User;
import com.octo.legacy.tripservice.tripservice.user.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.sql.DataSource;
import java.io.IOException;

@Component
public class LoggedUserServletFilter implements Filter {
    
    @Autowired
    private DataSource dataSource;
    
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
            throws IOException, ServletException {

        UserSession.CONTEXT.set(new User("JULIEN_JAK","Julien Jakubowski"));
        TripDAO.DATABASE = dataSource;
        filterchain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {}
}
