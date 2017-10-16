package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import com.hotel.model.entities.RequestEntity;
import com.hotel.domain.logic.SendRequest;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SendRequestCommand extends AbstractCommand {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        RequestEntity requestEntity = new RequestEntity();
        try {
            LOG.info("Creating new request.");
            requestEntity.setDateOfArriving(new Date(format.parse(request.getParameter("arrivingDate")).getTime()));
            requestEntity.setDateOfLeaving(new Date(format.parse(request.getParameter("leavingDate")).getTime()));
        } catch (ParseException e) {
        }
        requestEntity.setFirstName(request.getParameter("firstName"));
        requestEntity.setSecondName(request.getParameter("secondName"));
        requestEntity.setRoomClass(request.getParameter("roomClass"));
        requestEntity.setPassport(request.getParameter("passport"));
        requestEntity.setEmail(request.getParameter("email"));
        requestEntity.setOpen(true);
        if(SendRequest.sendRequest(requestEntity)) {
            LOG.info("Request was successfully created and sent.");
            return ViewManager.REQUEST_SENT_PASS;
        } else {
            LOG.error("Something goes wrong during request registration.");
            return ViewManager.ERROR_PAGE_PASS;
        }

    }
}

