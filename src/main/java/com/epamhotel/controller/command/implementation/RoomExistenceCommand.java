package com.epamhotel.controller.command.implementation;

import com.epamhotel.controller.command.AbstractCommand;
import com.epamhotel.controller.utils.ViewManager;
import com.epamhotel.domain.entities.RequestEntity;
import com.epamhotel.domain.logic.RoomExistance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoomExistenceCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestEntity entity = request.getParameterValues("currentRequest");
        if(RoomExistance.isRoomExist())
        return ;
    }
}
