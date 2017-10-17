package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPageCommand extends AbstractCommand {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    /**
     * Redirect to login page
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("Redirect to login page");
        return ViewManager.LOGIN_PAGE_PASS;
    }
}
