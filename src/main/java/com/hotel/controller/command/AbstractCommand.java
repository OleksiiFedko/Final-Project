package com.hotel.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommand {
    public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
