package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import com.hotel.model.entities.RootsEntity;
import com.hotel.domain.logic.Login;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand extends AbstractCommand {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        RootsEntity root = Login.checkRoot(login, password);
        if(root != null) {
            LOG.info("Authentication checking.");
            return checkAccessLevel(request, response, root.getRootName());
        } else {
            LOG.error("Something goes wrong.");
            request.setAttribute("error", "Incorrect login or password.");
            return ViewManager.ERROR_PAGE_PASS;
        }
    }

    public String checkAccessLevel(HttpServletRequest request, HttpServletResponse response, String rootName) {
        switch (rootName) {
            case "Admin":
                LOG.info("Administrator login into system.");
                return ViewManager.ADMIN_MAIN_PAGE_PASS;
            default:
                LOG.error("Incorrect login ro password. Redirect to error page.");
                return ViewManager.ERROR_PAGE_PASS;
        }
    }
}
