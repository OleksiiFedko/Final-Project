package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToAdminMenuCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return ViewManager.ADMIN_MAIN_PAGE_PASS;
    }
}