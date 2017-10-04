package com.epamhotel.controller.command.implementation;

import com.epamhotel.controller.command.AbstractCommand;
import com.epamhotel.controller.utils.ViewManager;
import com.epamhotel.domain.entities.RequestEntity;
import com.epamhotel.model.dao.connection.DBConnectionPool;
import com.epamhotel.model.dao.factorydao.AbstractDaoFactory;
import com.epamhotel.model.dao.factorydao.DaoFactory;
import com.epamhotel.model.dao.impldao.RequestDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpenRequestsCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return ViewManager.OPENED_REQUESTS_PAGE;
    }
}
