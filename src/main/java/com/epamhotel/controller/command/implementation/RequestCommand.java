package com.epamhotel.controller.command.implementation;

import com.epamhotel.controller.command.AbstractCommand;
import com.epamhotel.controller.utils.ViewManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return ViewManager.REQUEST_PAGE_PASS;
    }
}
