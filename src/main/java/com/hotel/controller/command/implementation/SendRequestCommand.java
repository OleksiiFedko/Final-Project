package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import com.hotel.domain.logic.RequestValidation;
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
    private static final Logger LOG = Logger.getLogger(SendRequestCommand.class);

    /**
     * Creating new request and add send it to DB
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        RequestEntity requestEntity = new RequestEntity();
        LOG.info("Creating new request.");
        try {
            requestEntity.setDateOfArriving(new Date(format.parse(request.getParameter("arrivingDate")).getTime()));
            requestEntity.setDateOfLeaving(new Date(format.parse(request.getParameter("leavingDate")).getTime()));
        } catch (ParseException | NullPointerException e) {
            LOG.error("You input invalid date or dont input it at all.");
            request.setAttribute("errorMessage", "Invalid date in request");
            return ViewManager.ERROR_PAGE_PASS;
        }
        boolean checkArr = RequestValidation.arrivingDateVsLeavingDate(requestEntity.getDateOfArriving(),
                                                                    requestEntity.getDateOfLeaving());
        boolean checkArrVsLeav = RequestValidation.checkArrivingDate(requestEntity.getDateOfArriving());
        requestEntity.setFirstName(request.getParameter("firstName"));
        if(checkArr) {
            LOG.error("Invalid date in request");
            request.setAttribute("errorMessage", "Invalid date in request");
            return ViewManager.ERROR_PAGE_PASS;
        }
        if(checkArrVsLeav) {
            LOG.error("Invalid date in request");
            request.setAttribute("errorMessage", "Invalid date in request");
            return ViewManager.ERROR_PAGE_PASS;
        }
        requestEntity.setFirstName(request.getParameter("firstName"));
        requestEntity.setSecondName(request.getParameter("secondName"));
        requestEntity.setRoomClass(request.getParameter("roomClass"));
        requestEntity.setPassport(request.getParameter("passport"));
        requestEntity.setEmail(request.getParameter("email"));
        requestEntity.setOpen(true);
        System.out.println(requestEntity);
        if(RequestValidation.isEmptyField(requestEntity)) {
            LOG.error("One ore more empty field in request.");
            request.setAttribute("errorMessage", "One ore more empty field in request.\n" +
                    "You need to fill all fields.");
            return ViewManager.ERROR_PAGE_PASS;
        }
        if(SendRequest.sendRequest(requestEntity)) {
            LOG.info("Request was successfully created and sent.");
            return ViewManager.REQUEST_SENT_PASS;
        } else {
            LOG.error("Something goes wrong during request registration.");
            return ViewManager.ERROR_PAGE_PASS;
        }
    }

}

