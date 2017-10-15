package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import com.hotel.model.entities.RootsEntity;
import com.hotel.domain.logic.Login;

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
