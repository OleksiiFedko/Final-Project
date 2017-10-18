package com.hotel.model.tags;

import com.hotel.model.dao.connection.DBConnectionPool;
import com.hotel.model.dao.factorydao.AbstractDaoFactory;
import com.hotel.model.dao.factorydao.DaoFactory;
import com.hotel.model.dao.impldao.RoomClassDao;
import com.hotel.model.entities.RoomClassEntity;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomsClassTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        List<RoomClassEntity> roomClassList = new ArrayList<>();
        JspWriter out = pageContext.getOut();
        AbstractDaoFactory daoFactory = new DaoFactory();
        try(Connection connection = DBConnectionPool.getConnection()) {
            RoomClassDao dao = daoFactory.getRoomClassDao(connection);
            roomClassList = dao.getAllItems();

//            out.write("<tr>");
//            out.write("<td>Room class</td>");
//            out.write("<td>");
            out.write("<select name=\"roomClass\">");
            out.write("<option disabled>Choose room class</option>");
            for(RoomClassEntity entity : roomClassList) {
                out.write("<option>" + entity.getRoomClass() + "</option>");
            }
            out.write("</select>");
//            out.write("</td>");
//            out.write("</tr>");

            out.flush();
            out.close();
        } catch (SQLException sqlE) {

        } catch (IOException e) {

        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
