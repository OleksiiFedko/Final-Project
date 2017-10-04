package com.epamhotel.controller.command.implementation;

import com.epamhotel.controller.command.AbstractCommand;
import com.epamhotel.controller.utils.ViewManager;
import com.epamhotel.domain.entities.RootsEntity;
import com.epamhotel.domain.logic.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        RootsEntity root = Login.checkRoot(login, password);
        if(root != null) {
            return checkAccessLevel(request, response, root.getRootName());
        } else {
            request.setAttribute("error", "Incorrect login or password.");
            return ViewManager.ERROR_PAGE_PASS;
        }
    }

    public String checkAccessLevel(HttpServletRequest request, HttpServletResponse response, String rootName) {
        switch (rootName) {
            case "Admin":
                return ViewManager.ADMIN_MAIN_PAGE_PASS;
            default:
                return ViewManager.ERROR_PAGE_PASS;
        }
    }
}
