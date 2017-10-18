package com.hotel.controller.servlets;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.command.CommandFactory;
import com.hotel.controller.command.implementation.LoginCommand;
import com.hotel.controller.command.implementation.RoomExistenceCommand;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(Controller.class);

    public Controller() {
        super();
        LOG.info("Create controller object.");
    }

    /**
     * Do get
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Do post
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Process request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("command");
        AbstractCommand command = CommandFactory.getCommand(action);
        String page = command.execute(request, response);
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }

}
