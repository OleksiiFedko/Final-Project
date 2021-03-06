package com.hotel.controller.command.implementation;

import com.hotel.controller.command.AbstractCommand;
import com.hotel.controller.utils.ViewManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartPageCommand extends AbstractCommand {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(StartPageCommand.class);

    /**
     * Redirect to start page (index.jsp)
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("Redirect to start page (index.jsp)");
        return ViewManager.INDEX_PAGE_PASS;
    }
}
