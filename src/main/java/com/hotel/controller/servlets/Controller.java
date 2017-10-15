package com.hotel.controller.servlets;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.command.CommandFactory;
import com.hotel.controller.command.implementation.RoomExistenceCommand;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    public Controller() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("command");
        AbstractCommand command = CommandFactory.getCommand(action);
        String page = command.execute(request, response);
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }
}
