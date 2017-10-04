package com.epamhotel.controller.servlets;

import com.epamhotel.controller.command.AbstractCommand;
import com.epamhotel.controller.command.CommandFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

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
