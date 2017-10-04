package com.epamhotel.controller.command.implementation;

import com.epamhotel.controller.command.AbstractCommand;
import com.epamhotel.controller.utils.ViewManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPageCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(true);
//        String language = (String) request.getParameter("language");
        return ViewManager.LOGIN_PAGE_PASS;
    }
}
