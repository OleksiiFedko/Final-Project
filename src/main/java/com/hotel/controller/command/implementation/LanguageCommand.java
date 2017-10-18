package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(true);
//        String lang = request.getParameter("lang");
//        if(lang.length() > 0) {
//            session.setAttribute("lang", lang);
//            return ViewManager.INDEX_PAGE_PASS;
//        } else {
//            lang = "en_EN";
//            session.setAttribute("lang", lang);
//            return ViewManager.INDEX_PAGE_PASS;
//        }
        HttpSession session = request.getSession(true);
        String lang = (String) request.getParameter("lang");
        session.setAttribute("lang", lang);
        return ViewManager.INDEX_PAGE_PASS;
    }
}
