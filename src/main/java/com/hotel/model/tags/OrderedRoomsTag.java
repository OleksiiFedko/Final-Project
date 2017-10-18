package com.hotel.model.tags;

import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.OrderDao;
import com.hotel.model.entities.OrderEntity;
import com.hotel.model.entities.RequestEntity;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedRoomsTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        List<OrderEntity> orderedRooms = new ArrayList<>();
        JspWriter out = pageContext.getOut();
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()) {
            OrderDao orderDao = daoFactory.getOrderDao(connection);
            orderedRooms = orderDao.getAllItems();

            for(OrderEntity entity : orderedRooms) {
                out.write("<tr>");
                out.write("<td>" + entity.getOrderId() + "</td>");
                out.write("<td>" + entity.getRoomNumber() + "</td>");
                out.write("<td>" + entity.getRequestEntity().getRoomClass() + "</td>");
                out.write("<td>" + entity.getRequestEntity().getDateOfArriving() + "</td>");
                out.write("<td>" + entity.getRequestEntity().getDateOfLeaving() + "</td>");
                out.write("<td>" + entity.getRequestEntity().getFirstName() + "</td>");
                out.write("<td>" + entity.getRequestEntity().getSecondName() + "</td>");
                out.write("<td>" + entity.getRequestEntity().getPassport() + "</td>");
                out.write("</tr>");
            }

            out.flush();
            out.close();
        } catch (SQLException sqlE) {
        } catch (IOException ioE) {

        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
