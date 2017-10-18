package com.hotel.controller.filters;

import com.hotel.controller.command.implementation.LoginCommand;
import com.hotel.controller.utils.ViewManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminSecureFilter implements javax.servlet.Filter {

    private static final Logger LOG = Logger.getLogger(AdminSecureFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        String root = (String) session.getAttribute("root");
        System.out.println(root);
        if(root != null) {
            chain.doFilter(request, response);
        } else {
            LOG.info("Try to get access for admin resources without authentication. Redirect to login page.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(ViewManager.LOGIN_PAGE_PASS);
            dispatcher.forward(request, response);
        }
    }


    @Override
    public void destroy() {

    }
}
